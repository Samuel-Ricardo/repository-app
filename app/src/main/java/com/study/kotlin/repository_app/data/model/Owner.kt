package com.study.kotlin.repository_app.data.model

import com.google.gson.annotations.SerializedName

data class Owner (
    val login: String,
    @SerializedName("avatar_url")
    val profileImageURL: String
    )