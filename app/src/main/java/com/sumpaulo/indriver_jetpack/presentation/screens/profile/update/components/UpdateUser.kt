package com.sumpaulo.indriver_jetpack.presentation.screens.profile.update.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sumpaulo.indriver_jetpack.domain.util.Resource
import com.sumpaulo.indriver_jetpack.presentation.components.ProgressBar
import com.sumpaulo.indriver_jetpack.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun UpdateUser(navController: NavHostController, viewModel: ProfileUpdateViewModel = hiltViewModel()) {
    val context = LocalContext.current
    when(val response  = viewModel.updateResponse){
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            LaunchedEffect(Unit) {
                viewModel.updateUserSession(response.data)
                Toast.makeText(context, "Dados Atualizados!", Toast.LENGTH_LONG).show()
            }

        }

        is Resource.Failure -> {
            Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if(response != null){
                Toast.makeText(context, "Problemas tecnicos ocorreram", Toast.LENGTH_LONG).show()
            }
        }
    }
}