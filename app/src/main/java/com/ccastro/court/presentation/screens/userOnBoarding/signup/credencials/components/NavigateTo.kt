package com.ccastro.court.presentation.screens.userOnBoarding.signup.credencials.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.core.Constans.TAG
import com.ccastro.court.presentation.navigation.AuthNavScreens
import com.ccastro.court.presentation.screens.userOnBoarding.signup.credencials.SignUpCredentialsViewModel

@Composable
fun NavigateTo (
    navHostController: NavHostController,
    viewModel: SignUpCredentialsViewModel = hiltViewModel()
) {

    viewModel.state.nextScreen?.let {
        Log.e(TAG, "NavigateTo from Signup to: $it")
        navHostController.navigate(it)
        {
            viewModel.state.nextScreen = null
        }
    }
}