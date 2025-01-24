package com.sumpaulo.indriver_jetpack.domain.useCases.auth

import com.sumpaulo.indriver_jetpack.domain.model.AuthResponse
import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository

class SaveSessionUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}