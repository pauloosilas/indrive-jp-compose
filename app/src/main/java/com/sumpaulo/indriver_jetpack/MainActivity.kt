package com.sumpaulo.indriver_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sumpaulo.indriver_jetpack.presentation.navigation.graph.root.RootNavGraph
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.login.LoginScreen
import com.sumpaulo.indriver_jetpack.ui.theme.IndriverjetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndriverjetpackTheme {
                Surface {
                    navHostController = rememberNavController()
                    RootNavGraph(navHostController)
                }
            }
        }
    }
}
