package com.ccastro.court.presentation.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun RootNavGraph( navHostController: NavHostController, activity: Activity) {

    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        introduceNavGraph(navHostController = navHostController)
        authNavGraph(navHostController = navHostController)
        homeNavGraph(navHostController = navHostController)
    }
}