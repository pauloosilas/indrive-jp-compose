package com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.update

data class ProfileUpdateState(
    val name:String = "",
    val lastname:String = "",
    val phone: String = "",
    val image: String? = null,
)