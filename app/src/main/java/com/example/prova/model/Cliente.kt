package com.example.prova.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clientes")
data class Cliente(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val codigo: String,
    val razao_social: String,
    val nomeFantasia: String,
    val cpf: String,
    val cnpj: String,
    val ramo_atividade: String,
    val endereco: String,
    val status: String,
    @Embedded
    val contatos: Contato
)