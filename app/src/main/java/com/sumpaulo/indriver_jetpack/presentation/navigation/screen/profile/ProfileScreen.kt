package com.sumpaulo.indriver_jetpack.presentation.navigation.screen.profile

sealed class ProfileScreen(val route:String) {
    object ProfileInfo: ProfileScreen("/profile/info")
    object ProfileUpdate: ProfileScreen("/profile/update/{user}"){
        fun passUser(user:String) = "/profile/update/${user}"
    }
}