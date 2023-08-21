package com.ccastro.court.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.introduceNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.INTRODUCE,
        startDestination = IntroduceNavScreens.AppPresentation.route
    ){
        composable(route = IntroduceNavScreens.Splash.route) {

        }
    }
}

sealed class IntroduceNavScreens(val route: String) {
    object Splash: IntroduceNavScreens(route = "Splash")
    object AppPresentation: IntroduceNavScreens(route = "Presentation")
}