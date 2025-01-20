package com.sumpaulo.indriver_jetpack.presentation.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sumpaulo.indriver_jetpack.presentation.navigation.Graph
import com.sumpaulo.indriver_jetpack.presentation.navigation.screen.auth.AuthScreen
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.login.LoginScreen
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.register.RegisterScreen


fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController = navController)
        }

        composable(route = AuthScreen.Register.route){
            RegisterScreen(navController = navController)
        }
    }
}