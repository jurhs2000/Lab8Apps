package com.example.lab8apps.ui.repos

import com.squareup.moshi.Json

data class GitUserProperty(
    val login:String,
    @Json(name = "avatar_url")
    val imgSrcUrl: String
)