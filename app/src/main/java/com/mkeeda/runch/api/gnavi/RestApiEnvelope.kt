package com.mkeeda.runch.api.gnavi

import com.mkeeda.runchdomain.entity.Restaurant

data class RestApiEnvelope(
    val total_hit_count: Int,
    val hit_per_page: Int,
    val rest: List<Restaurant>
)
