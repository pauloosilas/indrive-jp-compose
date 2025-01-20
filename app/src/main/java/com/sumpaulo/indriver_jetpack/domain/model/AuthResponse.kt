package com.sumpaulo.indriver_jetpack.domain.model

data class AuthResponse(
    val user: User? = null,
    val token:String? = null
)