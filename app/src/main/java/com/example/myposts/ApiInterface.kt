package com.example.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts():Call<List<post>>

    
    @GET("/posts/{id}")
    fun getPostById(@Path{id})
}