package com.example.prova.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contato")
data class Contato(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "contato_nome")
    val nome: String,
    val telefone: String,
    val celular: String,
    val conjuge: String,
    val tipo: String,
    val time: String,
    val e_mail: String,
    val data_nascimento: String,
    @ColumnInfo(name = "data_nascimento_conjuge")
    val dataNascimentoConjuge: String
)
