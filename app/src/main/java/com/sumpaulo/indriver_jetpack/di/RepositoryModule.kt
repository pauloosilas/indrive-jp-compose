package com.sumpaulo.indriver_jetpack.di

import com.sumpaulo.indriver_jetpack.data.dataSource.remote.service.AuthService
import com.sumpaulo.indriver_jetpack.data.repository.AuthRepositoryImpl
import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(authService: AuthService): AuthRepository =
        AuthRepositoryImpl(authService)
}