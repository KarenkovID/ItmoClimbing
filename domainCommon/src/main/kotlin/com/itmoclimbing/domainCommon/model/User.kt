package com.itmoclimbing.domainCommon.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
        val id: String,
        val firstName: String,
        val lastName: String
)