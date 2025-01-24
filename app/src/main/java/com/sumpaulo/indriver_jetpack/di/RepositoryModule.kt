package com.sumpaulo.indriver_jetpack.di

import com.sumpaulo.indriver_jetpack.data.local.datastore.LocalDatastore
import com.sumpaulo.indriver_jetpack.data.remote.dataSource.remote.service.AuthService
import com.sumpaulo.indriver_jetpack.data.remote.dataSource.remote.service.UserService
import com.sumpaulo.indriver_jetpack.data.remote.repository.AuthRepositoryImpl
import com.sumpaulo.indriver_jetpack.data.remote.repository.UserRepositoryImpl
import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository
import com.sumpaulo.indriver_jetpack.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authService: AuthService, localDatastore: LocalDatastore): AuthRepository =
        AuthRepositoryImpl(authService = authService, localDatastore = localDatastore)


@Provides
fun provideUserRepository(userService: UserService): UserRepository =
    UserRepositoryImpl(userService = userService)


}