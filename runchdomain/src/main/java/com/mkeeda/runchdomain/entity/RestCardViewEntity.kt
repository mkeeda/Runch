package com.mkeeda.runchdomain.entity

data class RestCardViewEntity(
    val id: String,
    val name: String,
    val imageUrl: String?,
    val category: String,
    val access: String
)
