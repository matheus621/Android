package com.example.prova.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.prova.model.Pedido

interface PedidoDao {

    @Query("SELECT * FROM PEDIDOS")
    fun getPedido(): Pedido

    @Query("SELECT * FROM PEDIDOS")
    suspend fun getAllLivePedido(): List<Pedido>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPedido(pedido: List<Pedido>)

    @Query("SELECT * FROM PEDIDOS WHERE ID = :id")
    fun getSimplePedido(id: Int) : LiveData<Pedido>
}