package com.sumpaulo.indriver_jetpack.data.remote.repository

import android.util.Log
import com.sumpaulo.indriver_jetpack.data.local.datastore.LocalDatastore
import com.sumpaulo.indriver_jetpack.data.remote.dataSource.remote.service.AuthService
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
    ): Resource<AuthResponse> {
        return try{
            val result = authService.login(email, password)
            if(result.isSuccessful){
                Log.d("AuthRepositoryImpl", "Data: ${result.body()!!}")
                Resource.Success(result.body()!!)
            }else {

                val errorResponse: ErrorResponse? = ErrorHelper.handleError(result.errorBody())

                Resource.Failure(errorResponse?.message ?: "Error na requisição...")
            }
        }catch(e:Exception){
            Log.d("AuthRepositoryImpl", "Message ${e}")
            Log.d("AuthRepositoryImpl", "Message causa ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error interno desconhecido...")
        }
    }

    override suspend fun register(user: User): Resource<AuthResponse> {
        return try{
            val result = authService.register(user)
            if(result.isSuccessful){
                Resource.Success(result.body()!!)
            }else {

                val errorResponse: ErrorResponse? = ErrorHelper.handleError(result.errorBody())
                Log.d("AuthRepositoryImpl", "Message Error ${errorResponse?.message}")
                Resource.Failure(errorResponse?.message ?: "Error na requisição...")
            }
        }catch(e:Exception){
            Log.d("AuthRepositoryImpl", "Message ${e}")
            Log.d("AuthRepositoryImpl", "Message causa ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error interno desconhecido...")
        }
    }

    override suspend fun saveSession(authResponse: AuthResponse) =
       localDatastore.save(authResponse)


    override suspend fun logout() =
        localDatastore.delete()


    override fun getSessionData(): Flow<AuthResponse> =
        localDatastore.getData()


}