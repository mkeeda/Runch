package com.mkeeda.runchdomain.entity

// FIXME: REST API と意味被ってね？
data class RestApiEnvelope(
    val total_hit_count: Int,
    val hit_per_page: Int,
    val rest: List<Restaurant>
)
