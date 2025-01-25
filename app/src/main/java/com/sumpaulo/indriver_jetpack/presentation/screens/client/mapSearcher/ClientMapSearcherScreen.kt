package com.sumpaulo.indriver_jetpack.presentation.screens.client.mapSearcher

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ClientMapSearcherScreen(navController: NavHostController) {
    Scaffold { paddingValues ->
        Text("Mapper", modifier = Modifier.padding(paddingValues))
    }
}