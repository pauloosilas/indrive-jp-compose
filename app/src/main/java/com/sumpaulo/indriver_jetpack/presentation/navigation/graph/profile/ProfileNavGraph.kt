package com.sumpaulo.indriver_jetpack.presentation.navigation.graph.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.sumpaulo.indriver_jetpack.presentation.navigation.Graph
import com.sumpaulo.indriver_jetpack.presentation.navigation.screen.profile.ProfileScreen
import com.sumpaulo.indriver_jetpack.presentation.screens.profile.info.ProfileInfoScreen
import com.sumpaulo.indriver_jetpack.presentation.screens.profile.update.ProfileUpdateScreen


fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController){
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileScreen.ProfileInfo.route
    ){
        composable(route = ProfileScreen.ProfileInfo.route){
            ProfileInfoScreen(navController = navController)
        }

        composable(
            route= ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
            )
        {
            it.arguments?.getString("user")?.let { user ->
                ProfileUpdateScreen(navController = navController, userParam = user)
            }
        }


    }
}