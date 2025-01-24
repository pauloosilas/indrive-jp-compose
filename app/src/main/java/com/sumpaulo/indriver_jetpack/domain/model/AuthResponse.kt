package com.sumpaulo.indriver_jetpack.domain.model

import com.google.gson.Gson

data class AuthResponse(
    val user: User? = null,
    val token:String? = null
){
    //json to string para armazenamento
    fun toJson():String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): AuthResponse = Gson().fromJson(data, AuthResponse::class.java)
    }
}
