package com.sumpaulo.indriver_jetpack.presentation.screens.auth.register

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel(){

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    fun onNameInput(input:String){
        state = state.copy(name = input)
    }

    fun onLastnameInput(input:String){
        state = state.copy(lastname = input)
    }

    fun onEmailInput(input:String){
        state = state.copy(email = input)
    }

    fun onPhoneInput(input:String){
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input:String){
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input:String){
        state = state.copy(confirmPassword = input)
    }

    fun register(){
        if(isValidForm()){
            Log.d("RegisterViewModel", state.name)
            Log.d("RegisterViewModel", state.lastname)
            Log.d("RegisterViewModel", state.email)
            Log.d("RegisterViewModel", state.phone)
            Log.d("RegisterViewModel", state.password)
            Log.d("RegisterViewModel", state.confirmPassword)
        }
    }

    fun isValidForm(): Boolean{
        if(state.name.isEmpty()){
            errorMessage = "Nome Requerido"
            return false
        }else if(state.lastname.isEmpty()){
            errorMessage = "Sobrenome Requerido"
            return false
        } else if(state.email.isEmpty()) {
            errorMessage = "Email Requerido"
            return false
        }
        else if(state.phone.isEmpty()) {
            errorMessage = "Telefone Requerido"
            return false
        }
        else if(state.password.isEmpty()) {
            errorMessage = "Password Requerido"
            return false
        }
        else if(state.confirmPassword.isEmpty()) {
            errorMessage = "Confirme a Senha"
            return false
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "Email invalido"
            return false
        }
        else if(state.password.length < 6 ){
            errorMessage = "A senha deve ter pelo menos 6 caracteres"
            return false
        }

        else if(state.password != state.confirmPassword){
            errorMessage = "Senhas não Coincidem "
            return false
        }


        return true
    }
}