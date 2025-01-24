package com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.update

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.sumpaulo.indriver_jetpack.domain.model.User
import com.sumpaulo.indriver_jetpack.domain.useCases.user.UserUseCases
import com.sumpaulo.indriver_jetpack.domain.util.Resource
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.update.mapper.toUser
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    private val userUseCases: UserUseCases,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    var state by mutableStateOf(ProfileUpdateState())
    private set

    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    var updateResponse by mutableStateOf<Resource<User>?>(null)
    private set

    fun update() = viewModelScope.launch {
        updateResponse = Resource.Loading
        val result = userUseCases.update(user.id.toString(), state.toUser(), file = null)
        updateResponse = result
    }

    init{
        state = state.copy(
            name = user.name,
            lastname = user.lastname,
            phone = user.phone,
            image = user.image
        )
    }

    fun onNameInput(input:String){
       state = state.copy(name = input)
    }

    fun onLastnameInput(input:String){
        state = state.copy(lastname = input)
    }

    fun onPhoneInput(input:String){
        state = state.copy(phone = input)
    }

    fun onImageInput(input:String){
       state = state.copy(image = input)
    }
}