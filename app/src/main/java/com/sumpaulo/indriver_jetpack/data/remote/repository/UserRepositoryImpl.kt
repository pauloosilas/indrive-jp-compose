package com.sumpaulo.indriver_jetpack.data.remote.repository

import android.util.Log
import com.sumpaulo.indriver_jetpack.data.remote.dataSource.remote.service.UserService
import com.sumpaulo.indriver_jetpack.domain.model.ErrorResponse
import com.sumpaulo.indriver_jetpack.domain.model.User
import com.sumpaulo.indriver_jetpack.domain.repository.UserRepository
import com.sumpaulo.indriver_jetpack.domain.util.ErrorHelper
import com.sumpaulo.indriver_jetpack.domain.util.Resource
import java.io.File

class UserRepositoryImpl(private val userService: UserService) : UserRepository {
    override suspend fun update(
        id: String,
        user: User,
        file: File?
    ):  Resource<User> {
        return try{
            val result = userService.update(id, user)
            if(result.isSuccessful){
                Log.d("UserRepositoryImpl", "Data: ${result.body()!!}")
                Resource.Success(result.body()!!)
            }else {

                val errorResponse: ErrorResponse? = ErrorHelper.handleError(result.errorBody())

                Resource.Failure(errorResponse?.message ?: "Error na requisição...")
            }
        }catch(e:Exception){
            Log.d("UserRepositoryImpl", "Message ${e}")
            Log.d("UserRepositoryImpl", "Message causa ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error interno desconhecido...")
        }
    }

}