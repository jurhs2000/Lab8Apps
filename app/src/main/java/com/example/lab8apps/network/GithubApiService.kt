package com.example.lab8apps.network

import com.example.lab8apps.ui.repos.GitUserProperty
import com.example.lab8apps.ui.repos.RepoProperty
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.github.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
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