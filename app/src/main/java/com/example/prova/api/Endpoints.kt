package com.example.prototipoprova.api

import com.example.prova.model.Cliente
import com.example.prova.model.Pedido
import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {

    @GET("cliente")
    fun getClientes(): Call<List<Cliente>>

    @GET("cliente/")
    suspend fun getClientesFromCoroutine(): ArrayList<Cliente>

    @GET("pedidos")
    fun getPedidos(): Call<List<Pedido>>

}