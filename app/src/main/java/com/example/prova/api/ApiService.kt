package com.example.prototipoprova.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://maximatech.free.beeceptor.com/android/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getEndpoints() : Endpoints {
        return getRetrofit().create(Endpoints::class.java)
    }
}