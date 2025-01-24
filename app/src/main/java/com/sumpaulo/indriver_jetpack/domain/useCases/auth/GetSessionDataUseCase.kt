package com.sumpaulo.indriver_jetpack.domain.useCases.auth

import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository

class GetSessionDataUseCase(private val repository: AuthRepository) {

    operator fun invoke() = repository.getSessionData()  //flow
}