package com.sumpaulo.indriver_jetpack.domain.repository

import com.sumpaulo.indriver_jetpack.domain.model.AuthResponse
import com.sumpaulo.indriver_jetpack.domain.util.Resource

interface AuthRepository {
    suspend fun login(email:String, password:String): Resource<AuthResponse>
}