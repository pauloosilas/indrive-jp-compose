package com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.info

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.info.components.ProfileInfoContent

@Composable
fun ProfileInfoScreen(navController: NavHostController) {
    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars
    ) { paddingValues ->
        ProfileInfoContent(navController = navController, paddingValues = paddingValues)
    }
}