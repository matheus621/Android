package com.example.prototipoprova.repository

import android.content.Context
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.prototipoprova.api.ApiService
import com.example.prova.database.AppDatabase
import com.example.prova.model.Cliente
import com.example.prova.util.Utils
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class ClienteRepository(context: Context) {

    val database = AppDatabase.getInstance(context)

    suspend fun getClientes(): List<Cliente> {
        return database.Dao().getAllLiveCliente()
    }

    fun fetchDataFromServer(context: Context) {

        Timber.plant(Timber.DebugTree())
        val request = ApiService.getEndpoints()
        if (Utils.isOnline(context)) {

            request.getClientes().enqueue(object : Callback<List<Cliente>> {

                override fun onFailure(call: Call<List<Cliente>>, t: Throwable) {
                    Log.e("Falha de comunicação", "Falha no request")
                    Toast.makeText(context, "ERRO NA COMUNICAÇÃO", Toast.LENGTH_LONG).show()

                }

                override fun onResponse(
                    call: Call<List<Cliente>>,
                    response: Response<List<Cliente>>
                ) {


                    if (response.code() == 200) {
                        Timber.d("${response.body()}")
                        val resultado = response.body()
                        resultado?.let { cliente ->
                            cliente.forEach {
                                doAsync {
                                    database.Dao().insertClientes(it)
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