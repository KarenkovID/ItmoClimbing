package com.itmoclimbing.domain.model

data class Route(
    val id: String,
    val name: String,
    val grade: String,
    val setters: List<User>,
    val solvedBy: List<User>,
    val imagesUrls: List<String>
)