package com.ccastro.court.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ccastro.court.presentation.screens.userOnBoarding.onBoardingApp.OnBoardingAppScreen
import com.ccastro.court.presentation.screens.userOnBoarding.splash.SplashScreen

fun NavGraphBuilder.introduceNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.INTRODUCE,
        startDestination = IntroduceNavScreens.Splash.route
    ){
        composable(route = IntroduceNavScreens.Splash.route) {
            SplashScreen(navHostController = navHostController)
        }

        composable(route = IntroduceNavScreens.AppPresentation.route) {
            OnBoardingAppScreen(navHostController = navHostController)
        }
    }
}

sealed class IntroduceNavScreens(val route: String) {
    object Splash: IntroduceNavScreens(route = "Splash")
    object AppPresentation: IntroduceNavScreens(route = "onBoardingApp")
}