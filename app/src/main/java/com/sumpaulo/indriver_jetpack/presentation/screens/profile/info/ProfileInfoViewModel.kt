package com.sumpaulo.indriver_jetpack.presentation.screens.profile.info

import androidx.compose.runtime.mutableStateOf
import com.sumpaulo.indriver_jetpack.domain.model.User
import com.sumpaulo.indriver_jetpack.domain.useCases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


@HiltViewModel
class ProfileInfoViewModel @Inject constructor(private val authUseCases: AuthUseCases) : ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    init{
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCases.getSessionData().collect(){ data ->
            user = data.user
        }
    }

    fun logout() = viewModelScope.launch {
        authUseCases.logout()
    }
}