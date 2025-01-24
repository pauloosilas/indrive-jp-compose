package com.sumpaulo.indriver_jetpack.domain.useCases.auth

import com.sumpaulo.indriver_jetpack.domain.model.User
import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository){
    suspend operator fun invoke(user:User) = repository.register(user)
}