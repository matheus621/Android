package com.example.prova.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pedidos")
data class Pedido(

    @PrimaryKey(autoGenerate = false)
    val id: Long,
    val numPedRca: String,
    val numPedERP: String,
    val dataPedido: String,
    val status: String,
    val critica: String,
    val valor: String,
    val cliente: String
)