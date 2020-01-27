package com.itmoclimbing.domainCommon.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Route(
        val id: Int,
        val name: String,
        val grade: String,
        val setter: User?,
        val description: String?
)