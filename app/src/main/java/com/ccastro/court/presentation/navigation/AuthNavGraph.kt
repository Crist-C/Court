package com.ccastro.court.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.ccastro.court.presentation.screens.userOnBoarding.login.LoginScreen
import com.ccastro.court.presentation.screens.userOnBoarding.signup.credencials.SignUpCredentialsScreen
import com.ccastro.court.presentation.screens.userOnBoarding.signup.personalInformation.SignUpPersonalInformationScreen

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthNavScreens.Login.route,
    ) {
        composable(route = AuthNavScreens.Login.route) {
            LoginScreen(navHostController = navHostController)
        }
        composable(route = AuthNavScreens.SingUpCredentials.route) {
            SignUpCredentialsScreen(navHostController = navHostController)
        }
        composable(
            route = AuthNavScreens.SingUpPersonalInformation.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let { userData ->
                SignUpPersonalInformationScreen(navHostController = navHostController, user = userData)
            }
        }
    }
}

sealed class AuthNavScreens (val route: String){
    object Login: AuthNavScreens("Login")
    object SingUpCredentials: AuthNavScreens("SingUpCredentials")
    object SingUpPersonalInformation: AuthNavScreens("SingUpPersonalInformation/{user}") {
        fun passUserCredentials(user: String) = "SingUpPersonalInformation/$user"
    }
}