package com.mkeeda.runch.api

data class ApiEnvelope<out T>(val success: Boolean, val result: T, val code: String?, val message: String?)
