package com.sumpaulo.indriver_jetpack.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(LoginState())
    private set

    var errorMessage by mutableStateOf("")


    fun onEmailInput(input: String){
        state = state.copy(email = input)
    }

    fun onPasswordInput(input:String){
        state = state.copy(password = input)
    }

    fun login(){
        if(isValidForm()){
            Log.d("LoginViewModel", "${state.email}")
            Log.d("LoginViewModel", "${state.password}")
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