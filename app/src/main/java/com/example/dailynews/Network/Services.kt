package com.example.dailynews.Network

import com.example.dailynews.News
import retrofit2.Response
import retrofit2.http.GET

interface Services {
    @GET("top-headlines?country=in&apiKey=815d35749214473f97d341fed561ce44")
    suspend fun getTopHeadlines(): Response<News>

    @GET("top-headlines?country=in&category=sports&apiKey=815d35749214473f97d341fed561ce44")
    suspend fun getSportsHeadline(): Response<News>

    @GET("top-headlines?country=in&category=entertainment&apiKey=815d35749214473f97d341fed561ce44")
    suspend fun getEntertainmentHeadline(): Response<News>

    @GET("top-headlines?country=in&category=business&apiKey=815d35749214473f97d341fed561ce44")
    suspend fun getBusinessHeadline(): Response<News>

    @GET("top-headlines?country=in&category=technology&apiKey=815d35749214473f97d341fed561ce44")
    suspend fun getTechnologyHeadline(): Response<News>
}