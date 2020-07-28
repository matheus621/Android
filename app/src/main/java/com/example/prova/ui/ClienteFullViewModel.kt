package com.example.prova.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.prototipoprova.repository.ClienteRepository

class ClienteFullViewModel(application: Application) : AndroidViewModel(application) {


    private val clienteRepository = ClienteRepository(application)

    init {
        clienteRepository.fetchDataFromServer(application)
    }


    fun setCurrentSelectedUserId(id: Int) {
        clienteRepository.setCurrentClienteSelected(id)
    }

    fun getUserLiveData() = clienteRepository.getSingleClienteDetails(getCurrentUserSelectId().value!!)

    fun getCurrentUserSelectId() = clienteRepository.currentClienteSelected


}