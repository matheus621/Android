package com.example.prova.ui

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.prototipoprova.repository.ClienteRepository
import com.example.prova.model.Cliente
import com.example.prova.model.Pedido
import com.example.prova.repository.PedidoRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class PedidoViewModel(context: Context) : ViewModel() {

    private val pedidoRepository = PedidoRepository(context)

    private val _pedidos = MutableLiveData<List<Pedido>>()
    var pedidos: LiveData<List<Pedido>> = _pedidos

    init {
        pedidoRepository.fetchDataFromServer(context)
    }

    fun getAllPedidos() {

        try {
            viewModelScope.launch {
                _pedidos.value = pedidoRepository.getPedidos()
            }
        } catch (e: Exception) {
            Timber.tag("ERRO API").e(e.message.toString())

        }

    }


}
