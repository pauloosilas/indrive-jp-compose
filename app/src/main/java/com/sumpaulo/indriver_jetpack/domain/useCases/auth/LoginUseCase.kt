package com.sumpaulo.indriver_jetpack.domain.useCases.auth

import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email:String, password:String) = repository.login(email, password)
}