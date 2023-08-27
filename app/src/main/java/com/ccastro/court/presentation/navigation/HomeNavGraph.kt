package com.ccastro.court.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ccastro.court.presentation.screens.home.HomeScreen

fun NavGraphBuilder.homeNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.HOME,
        startDestination = HomeNavScreens.UserHome.route
    ){
        composable(route = HomeNavScreens.UserHome.route) {
           HomeScreen(navHostController = navHostController)
        }
    }
}

sealed class HomeNavScreens(val route: String) {
    object UserHome:HomeNavScreens(route = "UserHome")
}