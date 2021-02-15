package com.example.prova.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.prova.model.Cliente
import com.example.prova.model.Pedido


@Database(entities = [Cliente::class, Pedido::class], version = 3)
abstract class AppDatabase() : RoomDatabase() {

    abstract fun Dao(): ClientesDao
    abstract fun DaoPedido(): PedidoDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "database.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE as AppDatabase
            } else {
                INSTANCE as AppDatabase
            }
        }
    }

}