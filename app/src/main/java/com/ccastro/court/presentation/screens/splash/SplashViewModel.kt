package com.ccastro.court.presentation.screens.splash

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ccastro.court.core.Constans.TAG
import com.ccastro.court.domain.use_cases.auth.AuthUseCases
import com.ccastro.court.domain.use_cases.user.UserUseCases
import com.ccastro.court.presentation.navigation.Graph
import com.ccastro.court.presentation.navigation.IntroduceNavScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val authUserUseCases: AuthUseCases): ViewModel() {
    var state by mutableStateOf(SplashState())

    fun validateUserIsLoged() {
        state.currentUser = authUserUseCases.getCurrentUser()
        state = if(state.currentUser != null) {
            Log.e(TAG,"User is NOT null")
            state.copy(
                nextScreen = Graph.HOME
            )
        } else {
            Log.e(TAG,"User IS NULL")
            state.copy(
                nextScreen = IntroduceNavScreens.AppPresentation.route
            )
        }
    }
}