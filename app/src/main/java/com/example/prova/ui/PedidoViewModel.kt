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

class PedidoViewModel(application: Application) : AndroidViewModel(application) {

    private val pedidoRepository = PedidoRepository(application)

    init {
        pedidoRepository.fetchDataFromServer(application)
    }

    fun getAllPedidos() = pedidoRepository.getAllPedidos()


}
