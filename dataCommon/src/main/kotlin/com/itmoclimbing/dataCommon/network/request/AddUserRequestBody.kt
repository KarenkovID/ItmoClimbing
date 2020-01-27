package com.itmoclimbing.dataCommon.network.request

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AddUserRequestBody (
        val firstName: String,
        val lastName: String
)