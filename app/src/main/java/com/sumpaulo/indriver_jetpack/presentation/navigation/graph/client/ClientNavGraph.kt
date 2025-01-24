package com.sumpaulo.indriver_jetpack.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sumpaulo.indriver_jetpack.presentation.navigation.Graph
import com.sumpaulo.indriver_jetpack.presentation.navigation.graph.profile.ProfileNavGraph

import com.sumpaulo.indriver_jetpack.presentation.navigation.screen.client.ClientScreen
import com.sumpaulo.indriver_jetpack.presentation.screens.auth.profile.info.ProfileInfoScreen

import com.sumpaulo.indriver_jetpack.presentation.screens.client.home.ClientHomeScreen
import com.sumpaulo.indriver_jetpack.presentation.screens.client.mapSearcher.ClientMapSearcherScreen

@Composable
fun ClientNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.MapSearch.route
    ){
//        composable(route = ClientScreen.Home.route){
//            ClientHomeScreen(navController = navController)
//        }

       ProfileNavGraph(navController = navController)

        composable(route = ClientScreen.MapSearch.route){
            ClientMapSearcherScreen(navController = navController)
        }
    }
}