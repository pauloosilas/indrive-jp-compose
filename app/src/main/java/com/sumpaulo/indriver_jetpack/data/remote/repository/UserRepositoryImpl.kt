package com.sumpaulo.indriver_jetpack.data.remote.repository

import android.util.Log
import com.sumpaulo.indriver_jetpack.data.remote.dataSource.remote.service.UserService
import com.sumpaulo.indriver_jetpack.data.util.HandleRequest
import com.sumpaulo.indriver_jetpack.domain.model.ErrorResponse
import com.sumpaulo.indriver_jetpack.domain.model.User
import com.sumpaulo.indriver_jetpack.domain.repository.UserRepository
import com.sumpaulo.indriver_jetpack.domain.util.ErrorHelper
import com.sumpaulo.indriver_jetpack.domain.util.Resource
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody

import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody

import java.io.File


class UserRepositoryImpl(private val userService: UserService) : UserRepository {

    override suspend fun update(
        id: String,
        user: User,
        file: File?
    ):  Resource<User> {

        if (file != null) {
            val connection = file.toURI().toURL().openConnection()
            val mimeType = connection.contentType
            val contentType = "text/plain"
            val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
            val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
            val nameData = user.name.toRequestBody(contentType.toMediaTypeOrNull())
            val lastname = user.lastname.toRequestBody(contentType.toMediaTypeOrNull())
            val phone = user.phone.toRequestBody(contentType.toMediaTypeOrNull())

            val result = userService.updateWithImage(fileFormData, id, nameData, lastname, phone)
            return HandleRequest.send(result)


        } else {
            return HandleRequest.send(userService.update(id, user))
        }
    }
}