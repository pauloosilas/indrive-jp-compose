package com.sumpaulo.indriver_jetpack.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User (
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("notification_token")
    val notificationToken: Any? = null,
    @SerializedName("roles")
    val roles: List<Role>
) : Serializable