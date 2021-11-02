package com.example.dailynews

import com.google.gson.annotations.SerializedName


data class News(
    @SerializedName("status")
    val status : String,
    @SerializedName("totalResults")
    val totalResults : String,
    @SerializedName("articles")
    val articles : ArrayList<Article>
)

data class Article(
    @SerializedName("source")
    val source: Source,
    @SerializedName("author")
    val author:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("url")
    val url:String,
    @SerializedName("urlToImage")
    val img_url:String,
    @SerializedName("publishedAt")
    val publish_date:String,
    @SerializedName("content")
    val content:String,
)

data class Source(
    @SerializedName("id")
    val id : String,
    @SerializedName("name")
    val name : String
)