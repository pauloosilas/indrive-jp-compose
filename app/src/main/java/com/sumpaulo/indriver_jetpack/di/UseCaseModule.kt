package com.sumpaulo.indriver_jetpack.di

import com.sumpaulo.indriver_jetpack.domain.repository.AuthRepository
import com.sumpaulo.indriver_jetpack.domain.repository.UserRepository
import com.sumpaulo.indriver_jetpack.domain.useCases.auth.AuthUseCases
import com.sumpaulo.indriver_jetpack.domain.useCases.auth.GetSessionDataUseCase
import com.sumpaulo.indriver_jetpack.domain.useCases.auth.LoginUseCase
import com.sumpaulo.indriver_jetpack.domain.useCases.auth.LogoutUseCase
import com.sumpaulo.indriver_jetpack.domain.useCases.auth.RegisterUseCase
import com.sumpaulo.indriver_jetpack.domain.useCases.auth.SaveSessionUseCase
import com.sumpaulo.indriver_jetpack.domain.useCases.user.UserUpdateUseCase
import com.sumpaulo.indriver_jetpack.domain.useCases.user.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCases(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository)
    )

    @Provides
    fun provideUserUseCases(userRepository: UserRepository) = UserUseCases(
        update = UserUpdateUseCase(userRepository)
    )
}