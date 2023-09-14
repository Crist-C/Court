package com.ccastro.court.presentation.screens.userOnBoarding.splash.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.core.Constans.TAG
import com.ccastro.court.presentation.navigation.IntroduceNavScreens
import com.ccastro.court.presentation.screens.userOnBoarding.splash.SplashViewModel

@Composable
fun NavigateTo(navHostController: NavHostController, viewModel: SplashViewModel = hiltViewModel()) {
    val state = viewModel.state
    if(state.nextScreen != null && !state.nextScreenWasLaunched) {
        Log.e(TAG, "NavigateTo From Splash to: ${state.nextScreen}")
        navHostController.navigate(state.nextScreen!!) {
            navHostController.popBackStack()
            popUpTo(IntroduceNavScreens.Splash.route)
            state.nextScreenWasLaunched = true
        }
    }
}