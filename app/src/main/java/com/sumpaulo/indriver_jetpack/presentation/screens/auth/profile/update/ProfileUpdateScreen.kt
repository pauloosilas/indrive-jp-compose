package com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.update

import android.util.Log
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.update.components.ProfileUpdateContent
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.update.components.UpdateUser

@Composable
fun ProfileUpdateScreen(navController: NavHostController, userParam:String) {

    Log.d("ProfileUpdateScreen", "Data: ${userParam}")

    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars
    ) { paddingValues ->
        ProfileUpdateContent(navController = navController, paddingValues = paddingValues)
    }

    UpdateUser(navController = navController)
}