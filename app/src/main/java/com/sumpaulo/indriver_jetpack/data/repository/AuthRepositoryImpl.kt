package com.sumpaulo.indriver_jetpack.data.repository

import com.sumpaulo.indriver_jetpack.domain.model.AuthResponse
import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository
import com.sumpaulo.indriver_jetpack.domain.util.Resource

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Resource<AuthResponse> {
        TODO("Not yet implemented")
    }
}