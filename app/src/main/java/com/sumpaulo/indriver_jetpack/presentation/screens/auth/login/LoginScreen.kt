package com.sumpaulo.indriver_jetpack.presentation.screens.auth.login

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.login.components.Login
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.login.components.LoginContent
import com.sumpaulo.indriver_jetpack.ui.theme.IndriverjetpackTheme

@Composable
fun LoginScreen(navController: NavHostController){


    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars
    ) { paddingValues ->
        LoginContent(paddingValues, navController)
    }

    Login()
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    IndriverjetpackTheme {
        LoginScreen(navController = rememberNavController())
    }
}