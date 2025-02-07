package com.sumpaulo.indriver_jetpack.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.sumpaulo.indriver_jetpack.domain.model.AuthResponse
import com.sumpaulo.indriver_jetpack.domain.useCases.auth.AuthUseCases
import com.sumpaulo.indriver_jetpack.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCases
): ViewModel() {

    init{
        getSessionData()
    }

    var state by mutableStateOf(LoginState())
    private set

    var errorMessage by mutableStateOf("")

    var loginResponse by mutableStateOf<Resource<AuthResponse>?>(null)
    private set

    fun onEmailInput(input: String){
        state = state.copy(email = input)
    }

    fun onPasswordInput(input:String){
        state = state.copy(password = input)
    }

    fun login() = viewModelScope.launch{
        if(isValidForm()){
            loginResponse = Resource.Loading
            val result = authUseCase.login(state.email, state.password)
            loginResponse = result

        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun getSessionData() = viewModelScope.launch{
        authUseCase.getSessionData().collect(){ data ->
            Log.d("LoginViewModel", "Dados sessão: ${data}")
            if(!data.token.isNullOrBlank()){
                loginResponse = Resource.Success(data)
            }
        }
    }

    fun isValidForm(): Boolean{
        if(state.email.isEmpty()){
           errorMessage = "Email requerido"
            return false
        }
        if(state.password.isEmpty()){
            errorMessage = "Senha requerida"
            return false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "Email invalido!"
        }
        else if(state.password.length < 6 ){
            errorMessage = "A senha deve conter pelo menos 6 caracteres"
            return false
        }
        return true
    }

}