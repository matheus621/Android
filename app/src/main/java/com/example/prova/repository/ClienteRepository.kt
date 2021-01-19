package com.example.prototipoprova.repository

import android.content.Context
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.prototipoprova.api.ApiService
import com.example.prova.database.AppDatabase
import com.example.prova.model.Cliente
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class ClienteRepository(context: Context) {

    val currentClienteSelected: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun setCurrentClienteSelected(clienteIdSelected: Int) {
        currentClienteSelected.value = clienteIdSelected
    }

    fun getSingleClienteDetails(id: Int) = database.Dao().getSimpleCliente(id)

    val database = AppDatabase.getInstance(context)

    fun getCliente() = database.Dao().getCliente()

    fun fetchDataFromServer(context: Context) {

        Timber.plant(Timber.DebugTree())
        val request = ApiService.getEndpoints()
        val callback = request.getClientes()

        callback.enqueue(object : Callback<List<Cliente>> {
            override fun onFailure(call: Call<List<Cliente>>, t: Throwable) {
                Log.e("Falha de comunicação", "Falha no request")
            }

            override fun onResponse(call: Call<List<Cliente>>, response: Response<List<Cliente>>) {

                if (response.code() == 200) {
                    Timber.d("${response.body()}")
                    val resultado = response.body()
                    resultado?.let { cliente ->
                        cliente.forEach {
                            doAsync {
                                database.Dao().getCliente()
                            }
                        }
                    }
                } else {
                        Toast.makeText(context, "VOCÊ ESTÁ SEM INTERNET", Toast.LENGTH_LONG).show()
                        Handler().postDelayed({

                            fetchDataFromServer(context)

                        }, Toast.LENGTH_LONG.toLong() + 5000)
                }
//                Timber.d("${response.body()}")
//                val resultado = response.body()
//                    database.Dao().insertSimpleUsers(resultado)
            }

        })

    }

}