package com.example.lab8apps.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.github.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface GithubApiService {

    @GET("/users/{valors}")
    fun getUser(@Path("valors") valors: String?):
            Call<GitUserProperty>

    @GET("/users/{valors}/repos")
    fun getRepos(@Path("valors") valors: String?):
            Call<List<RepoProperty>>
}

object GithubApi {
    val retrofitService: GithubApiService by lazy {
        retrofit.create(GithubApiService::class.java)
    }
}