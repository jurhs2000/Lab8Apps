package com.example.lab8apps.network

import com.squareup.moshi.Json

data class RepoProperty(
    val name:String,
    val description: String?,
    @Json(name = "html_url")
    val htmlUrl: String

)