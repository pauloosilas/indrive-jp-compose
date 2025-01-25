package com.sumpaulo.indriver_jetpack.presentation.screens.profile.update.mapper

import com.sumpaulo.indriver_jetpack.domain.model.User
import com.sumpaulo.indriver_jetpack.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}