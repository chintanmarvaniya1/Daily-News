package com.example.dailynews.Network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientAPI {
    const val API_KEY = "apiKey=815d35749214473f97d341fed561ce44"

    val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()


    val retro = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val api = retro.create(Services::class.java)
}