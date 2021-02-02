package com.example.prova.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.prototipoprova.repository.ClienteRepository

class ClientesViewModel(application: Application) : AndroidViewModel(application) {

    private val clienteRepository = ClienteRepository(application)

    init {
        clienteRepository.fetchDataFromServer(application)
    }

    fun getAllClientes() = clienteRepository.getAllCliente()


}
