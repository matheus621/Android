package com.example.prova.repository

import android.content.Context
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.example.prototipoprova.api.ApiService
import com.example.prova.database.AppDatabase
import com.example.prova.model.Pedido
import com.example.prova.util.Utils
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class PedidoRepository(context: Context) {

    val database = AppDatabase.getInstance(context)

    suspend fun getPedidos(): List<Pedido> {
        return database.DaoPedido().getAllLivePedido()
    }


    fun fetchDataFromServer(context: Context) {

        Timber.plant(Timber.DebugTree())
        val request = ApiService.getEndpoints()
        if (Utils.isOnline(context)) {

            request.getPedidos().enqueue(object : Callback<List<Pedido>> {

                override fun onFailure(call: Call<List<Pedido>>, t: Throwable) {
                    Log.e("Falha de comunicação", "Falha no request")
                    Toast.makeText(context, "ERRO NA COMUNICAÇÃO", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<List<Pedido>>,
                    response: Response<List<Pedido>>
                ) {


                    if (response.code() == 200) {
                        Timber.d("${response.body()}")
                        val resultado = response.body()
                        resultado?.let { pedido ->
                            pedido.forEach {
                                doAsync {
                                    database.DaoPedido().insertPedido(pedido)
                                }
                            }
                        }
                    } else {
                        Toast.makeText(context, "VOCÊ ESTÁ SEM INTERNET", Toast.LENGTH_LONG).show()
                        Handler().postDelayed({

                            fetchDataFromServer(context)

                        }, Toast.LENGTH_LONG.toLong() + 5000)
                    }
                }

            })

        }
    }

}