package com.sumpaulo.indriver_jetpack.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sumpaulo.indriver_jetpack.domain.util.Resource
import com.sumpaulo.indriver_jetpack.presentation.components.ProgressBar
import com.sumpaulo.indriver_jetpack.presentation.navigation.Graph
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.register.RegisterViewModel

@Composable
fun Register(navController: NavHostController, viewModel: RegisterViewModel = hiltViewModel()){
    val context = LocalContext.current
    when(val response = viewModel.registerResponse){
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
            Toast.makeText(context, response.message , Toast.LENGTH_LONG).show()
        }

        else -> {
            if(response != null) {
                Toast.makeText(context, "Error desconhecido" , Toast.LENGTH_LONG).show()
            }
        }
    }
}