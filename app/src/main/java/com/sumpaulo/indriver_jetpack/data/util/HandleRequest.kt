package com.sumpaulo.indriver_jetpack.data.util

import android.util.Log
import com.sumpaulo.indriver_jetpack.domain.model.ErrorResponse
import com.sumpaulo.indriver_jetpack.domain.util.ErrorHelper
import com.sumpaulo.indriver_jetpack.domain.util.Resource
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response

object HandleRequest {
    fun <T> send(result:Response<T>, tag:String="HandleRequest"): Resource<T>{
       return try{

            if(result.isSuccessful){
                Log.d(tag, "Data: ${result.body()!!}")
                Resource.Success(result.body()!!)
            }else {

                val errorResponse: ErrorResponse? = ErrorHelper.handleError(result.errorBody())

                Resource.Failure(errorResponse?.message ?: "Error na requisição...")
            }
        }catch(e: HttpException){
            Log.d("HttpException: {$tag}", "Message ${e}")
            Log.d("HttpException: {$tag}", "Message causa ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error interno desconhecido...")
        }
       catch(e: IOException){
           Log.d("IOException: {$tag}", "Message ${e}")
           Log.d("IOException: {$tag}", "Message causa ${e.cause}")
           e.printStackTrace()
           Resource.Failure(e.message ?: "Verifique sua conexão com a internet...")
       }
       catch(e:Exception){
           Log.d("Exception: {$tag}", "Message ${e}")
           Log.d("Exception: {$tag}", "Message causa ${e.cause}")
           e.printStackTrace()
           Resource.Failure(e.message ?: "Error interno desconhecido...")
       }
    }
}