package com.ccastro.court.presentation.screens.userOnBoarding.splash

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ccastro.court.core.Constans.TAG
import com.ccastro.court.domain.use_cases.auth.AuthUseCases
import com.ccastro.court.presentation.navigation.Graph.HOME
import com.ccastro.court.presentation.navigation.IntroduceNavScreens.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val authUserUseCases: AuthUseCases): ViewModel() {
    var state by mutableStateOf(SplashState())

    fun validateUserIsLoged() {

        authUserUseCases.logout()

        state.currentUser = authUserUseCases.getCurrentUser()

        state = if(state.currentUser != null) {

            Log.e(TAG,"User is NOT null")
            state.copy(nextScreen = HOME)

        } else {
            Log.e(TAG,"User IS NULL")
            state.copy(nextScreen = AppPresentation.route)
        }
    }

}