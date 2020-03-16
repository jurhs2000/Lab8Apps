package com.example.lab8apps.ui.repos

import com.squareup.moshi.Json

data class RepoProperty(
    val name:String,
    @Json(name = "html_url")
    val repoSrcUrl: String

)