package com.sumpaulo.indriver_jetpack.data.remote.repository

import android.util.Log
import com.sumpaulo.indriver_jetpack.data.local.datastore.LocalDatastore
import com.sumpaulo.indriver_jetpack.data.remote.dataSource.remote.service.AuthService
import com.sumpaulo.indriver_jetpack.data.util.HandleRequest
import com.sumpaulo.indriver_jetpack.domain.model.AuthResponse
import com.sumpaulo.indriver_jetpack.domain.model.ErrorResponse
import com.sumpaulo.indriver_jetpack.domain.model.User
import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository
import com.sumpaulo.indriver_jetpack.domain.util.ErrorHelper
import com.sumpaulo.indriver_jetpack.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authService: AuthService,
    private val localDatastore: LocalDatastore
) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Resource<AuthResponse> = HandleRequest.send( authService.login(email, password) )

    override suspend fun register(user: User): Resource<AuthResponse> = HandleRequest.send(authService.register(user))

    override suspend fun saveSession(authResponse: AuthResponse) =
       localDatastore.save(authResponse)

    override suspend fun updateSession(user: User) {
       localDatastore.update(user)
    }


    override suspend fun logout() =
        localDatastore.delete()


    override fun getSessionData(): Flow<AuthResponse> =
        localDatastore.getData()


}