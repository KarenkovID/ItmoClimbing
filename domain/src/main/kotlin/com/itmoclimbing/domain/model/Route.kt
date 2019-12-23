package com.itmoclimbing.domain.model

data class Route(
    val id: String,
    val name: String,
    val grade: String,
    val setter: User,
    val description: String,
    val imagesUrls: List<String>
)