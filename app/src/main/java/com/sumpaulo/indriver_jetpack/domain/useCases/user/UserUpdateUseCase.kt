package com.sumpaulo.indriver_jetpack.domain.useCases.user

import com.sumpaulo.indriver_jetpack.domain.model.User
import com.sumpaulo.indriver_jetpack.domain.repository.UserRepository
import java.io.File

class UserUpdateUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(id: String, user: User, file: File?) = repository.update(id, user, file)
}