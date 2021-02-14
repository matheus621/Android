package com.example.prova.ui

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.prototipoprova.repository.ClienteRepository
import com.example.prova.model.Cliente
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class ClientesViewModel(context: Context) : ViewModel() {

    private val clienteRepository = ClienteRepository(context)

    private val _clientes = MutableLiveData<List<Cliente>>()
    var clientes : LiveData<List<Cliente>> = _clientes

    init {
        clienteRepository.fetchDataFromServer(context)
    }

//    fun setCurrentClienteSelected(id: Int) {
//        clienteRepository.setCurrentClienteSelected(id)
//    }

    //fun getAllClientes() = clienteRepository.getAllClientes()

    fun getAllClientes2(){

        try{
            viewModelScope.launch {
               _clientes.value =  clienteRepository.getClientes()
            }
        }catch (e: Exception) {
            Timber.tag("ERRO API").e(e.message.toString())

        }

    }


//    fun getAllClientes2Api(){
//
//        try{
//            viewModelScope.launch {
//                _clientes.value =  clienteRepository.getClientesFromApi()
//            }
//        }catch (e: Exception){
//            Log.e("ERRO API", e.message.toString())
//
//        }
//
//    }
    //fun getClienteLiveData() = clienteRepository.getSingleClienteDetails(getAllClientes())




}
