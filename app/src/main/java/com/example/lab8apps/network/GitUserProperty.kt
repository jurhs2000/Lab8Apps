package com.example.lab8apps.network

import com.squareup.moshi.Json

data class GitUserProperty(
    val login: String,
    @Json(name = "avatar_url")
    val avatarUrl: String
)