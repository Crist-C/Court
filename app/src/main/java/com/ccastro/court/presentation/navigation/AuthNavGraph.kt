package com.ccastro.court.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.ccastro.court.presentation.screens.login.LoginScreen

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthNavScreens.Login.route,
    ) {
        composable(route = AuthNavScreens.Login.route) {
            LoginScreen(navHostController = navHostController)
        }
        composable(route = AuthNavScreens.SingUp.route) {
            LoginScreen(navHostController = navHostController)
        }
    }
}

sealed class AuthNavScreens (val route: String){
    object Login: AuthNavScreens("Login")
    object SingUp: AuthNavScreens("SingUp")
}