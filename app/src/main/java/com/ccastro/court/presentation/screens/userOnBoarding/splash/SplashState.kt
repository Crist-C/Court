package com.ccastro.court.presentation.screens.userOnBoarding.splash

import com.google.firebase.auth.FirebaseUser

data class SplashState (
    var nextScreen: String? = null,
    var currentUser: FirebaseUser? = null,
    var nextScreenWasLaunched: Boolean = false
)