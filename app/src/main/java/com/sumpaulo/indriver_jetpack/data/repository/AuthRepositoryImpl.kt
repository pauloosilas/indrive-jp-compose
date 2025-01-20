package com.sumpaulo.indriver_jetpack.data.repository

import android.util.Log
import com.sumpaulo.indriver_jetpack.data.dataSource.remote.service.AuthService
import com.sumpaulo.indriver_jetpack.domain.model.AuthResponse
import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository
import com.sumpaulo.indriver_jetpack.domain.util.Resource

class AuthRepositoryImpl(private val authService: AuthService) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): Resource<AuthResponse> {
        return try{
            val result = authService.login(email, password)
            if(result.isSuccessful){
                Log.d("AuthRepositoryImpl", "Data: ${result.body()!!}")
                Resource.Success(result.body()!!)
            }
                Resource.Failure("Error na requisição...")

        }catch(e:Exception){
            Log.d("AuthRepositoryImpl", "Message ${e}")
            Log.d("AuthRepositoryImpl", "Message causa ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error interno desconhecido...")
        }
    }

}