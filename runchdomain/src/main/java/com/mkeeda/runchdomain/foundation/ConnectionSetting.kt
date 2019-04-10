package com.mkeeda.runchdomain.foundation

data class ConnectionSetting(
    val url: String,
    val username: String,
    val password: String,
    val pfxBase64: String?,
    val pfxPassword: String?
)
