package com.ccastro.court.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ccastro.court.presentation.screens.appPresentation.AppPresentationScreen
import com.ccastro.court.presentation.screens.splash.SplashScreen

fun NavGraphBuilder.introduceNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.INTRODUCE,
        startDestination = IntroduceNavScreens.AppPresentation.route
    ){
        composable(route = IntroduceNavScreens.Splash.route) {
            SplashScreen(navHostController = navHostController)
        }

        composable(route = IntroduceNavScreens.AppPresentation.route) {
            AppPresentationScreen(navHostController = navHostController)
        }
    }
}

sealed class IntroduceNavScreens(val route: String) {
    object Splash: IntroduceNavScreens(route = "Splash")
    object AppPresentation: IntroduceNavScreens(route = "Presentation")
}