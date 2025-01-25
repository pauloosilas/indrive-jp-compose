package com.sumpaulo.indriver_jetpack.domain.useCases.auth

data class AuthUseCases(
    val login: LoginUseCase,
    val register: RegisterUseCase,

    val saveSession: SaveSessionUseCase,
    val getSessionData: GetSessionDataUseCase,
    val logout: LogoutUseCase,
    val updateSession: UpdateSessionUseCase
)