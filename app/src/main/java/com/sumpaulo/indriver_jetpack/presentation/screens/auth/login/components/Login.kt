package com.sumpaulo.indriver_jetpack.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sumpaulo.indriver_jetpack.domain.util.Resource
import com.sumpaulo.indriver_jetpack.presentation.components.ProgressBar
import com.sumpaulo.indriver_jetpack.presentation.navigation.Graph
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {
    val context = LocalContext.current
    when(val response  = viewModel.loginResponse){
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            LaunchedEffect(Unit) {
                viewModel.saveSession(response.data)
                navController.navigate(route = Graph.CLIENT) {
                    popUpTo(Graph.AUTH){inclusive = true}
                }
            }

        }

        is Resource.Failure -> {
            Toast.makeText(context, response.message, Toast.LENGTH_SHORT).show()
        }

        else -> {
            if(response != null){
                Toast.makeText(context, "Problemas tecnicos ocorreram", Toast.LENGTH_SHORT).show()
            }
        }
    }
}