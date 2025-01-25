package com.sumpaulo.indriver_jetpack.presentation.screens.profile.info

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.sumpaulo.indriver_jetpack.presentation.screens.profile.info.components.ProfileInfoContent

@Composable
fun ProfileInfoScreen(navController: NavHostController) {
    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars
    ) { paddingValues ->
        ProfileInfoContent(navController = navController, paddingValues = paddingValues)
    }
}