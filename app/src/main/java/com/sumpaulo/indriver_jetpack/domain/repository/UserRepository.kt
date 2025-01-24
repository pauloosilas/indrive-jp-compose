package com.sumpaulo.indriver_jetpack.domain.repository

import com.sumpaulo.indriver_jetpack.domain.model.User
import com.sumpaulo.indriver_jetpack.domain.util.Resource
import java.io.File

interface UserRepository {

    suspend fun update(id: String, user:User, file: File?): Resource<User>
}