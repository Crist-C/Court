package com.ccastro.court.presentation.screens.userOnBoarding.login

import com.ccastro.court.R
import com.google.firebase.auth.FirebaseUser

data class LoginState(

    var email: String = "",
    var isEmailValid: Boolean = false,
    var emailErrorMsg: Int = R.string.empty_string,

    var password: String = "",
    var isPasswordValid: Boolean = false,
    var passwordErrorMsg: Int = R.string.empty_string,

    var isEnabledLoginButton: Boolean = false,

    var currentUser: FirebaseUser? = null

)
