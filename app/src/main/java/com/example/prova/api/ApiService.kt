package com.example.prototipoprova.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://provaws.herokuapp.com/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getEndpoints() : Endpoints {
        return getRetrofit().create(Endpoints::class.java)
    }
}