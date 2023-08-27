package com.ccastro.court.presentation.screens.splash.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.core.Constans.TAG
import com.ccastro.court.presentation.navigation.Graph
import com.ccastro.court.presentation.navigation.IntroduceNavScreens
import com.ccastro.court.presentation.screens.splash.SplashViewModel

@Composable
fun NavigateTo(navHostController: NavHostController, viewModel: SplashViewModel = hiltViewModel()) {
    val state = viewModel.state
    state.nextScreen?.let {
        Log.e(TAG, "NavigateTo: ${state.nextScreen}")
        navHostController.navigate(it) {
            navHostController.popBackStack()
            popUpTo(IntroduceNavScreens.Splash.route)
        }
    }
}