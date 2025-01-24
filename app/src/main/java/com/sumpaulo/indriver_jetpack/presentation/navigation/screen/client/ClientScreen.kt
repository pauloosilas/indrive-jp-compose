package com.sumpaulo.indriver_jetpack.presentation.navigation.screen.client

sealed class ClientScreen(val route:String) {
    object MapSearch: ClientScreen("/client/map/searcher")
}