package com.example.prototipoprova.api

import com.example.prototipoprova.model.Cliente
import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {

    @GET("cliente")
    fun getClientes(): Call<Cliente>

}