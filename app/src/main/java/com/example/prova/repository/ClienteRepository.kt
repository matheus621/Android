package com.example.prototipoprova.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.prototipoprova.api.ApiService
import com.example.prova.database.AppDatabase
import com.example.prova.model.Cliente
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

    fun getCliente() = database.Dao().getAllLiveCliente()

    fun fetchDataFromServer(context: Context) {

        Timber.plant(Timber.DebugTree())
        val request = ApiService.getEndpoints()
        val callback = request.getClientes()

        callback.enqueue(object : Callback<Cliente> {
            override fun onFailure(call: Call<Cliente>, t: Throwable) {
                Log.e("Falha de comunicação", "Falha no request")
            }

            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {

                Timber.d("${response.body()}")
                val resultado = response.body()
                /*listOf(resultado)?.let { clientes ->
                    clientes.forEach {
                        doAsync {
                            database.Dao().insertSimpleUsers(clientes)
                        }
                    }
                }*/
//                database.Dao().insertSimpleUsers(resultado)
            }

        })

    }

}