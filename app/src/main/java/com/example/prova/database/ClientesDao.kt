package com.example.prova.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.prova.model.Cliente

@Dao
interface ClientesDao {

    @Query("SELECT * FROM CLIENTES")
    fun getCliente(): LiveData<Cliente>

//    @Query("SELECT * FROM CLIENTES")
//    fun getAllLiveCliente(): LiveData<List<Cliente>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSimpleUsers(cliente: Cliente)

    @Query("SELECT * FROM CLIENTES WHERE ID = :id")
    fun getSimpleCliente(id: Int) : LiveData<Cliente>

}