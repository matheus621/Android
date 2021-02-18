package com.example.prova.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.prova.model.Pedido

@Dao
interface PedidoDao {

    @Query("SELECT * FROM PEDIDOS")
    fun getPedido(): Pedido

    @Query("SELECT * FROM PEDIDOS")
    suspend fun getAllLivePedido(): List<Pedido>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPedido(pedidos: List<Pedido>)

    @Query("SELECT * FROM PEDIDOS WHERE ID = :id")
    fun getSimplePedido(id: Int) : LiveData<Pedido>
}