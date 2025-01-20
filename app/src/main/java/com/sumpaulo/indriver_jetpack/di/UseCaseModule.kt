package com.sumpaulo.indriver_jetpack.di

import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository
import com.sumpaulo.indriver_jetpack.domain.useCases.auth.AuthUseCase
import com.sumpaulo.indriver_jetpack.domain.useCases.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository)
    )
}