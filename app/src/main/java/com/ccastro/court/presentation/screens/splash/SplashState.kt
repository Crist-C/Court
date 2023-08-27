package com.ccastro.court.presentation.screens.splash

import com.google.firebase.auth.FirebaseUser

data class SplashState (
    val nextScreen: String? = null,
    var currentUser: FirebaseUser? = null
)