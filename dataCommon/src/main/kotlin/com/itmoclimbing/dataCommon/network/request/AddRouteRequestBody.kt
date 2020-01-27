package com.itmoclimbing.dataCommon.network.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AddRouteRequestBody(
        @Json(name = "name") val name: String,
        @Json(name = "grade") val grade: String,
        @Json(name = "description") val description: String
)