package com.ccastro.court.presentation.screens.userOnBoarding.signup.credencials

import com.ccastro.court.R
import com.ccastro.court.domain.models.User
import com.ccastro.court.presentation.components.models.FormModel
import com.ccastro.court.presentation.navigation.AuthNavScreens
import com.google.gson.Gson


data class SignUpCredentialsState(

    var email: String = "castro.cristiank@gmail.com",
    var isEmailValid: Boolean = false,
    var emailErrorMsg: Int = R.string.empty_string,

    var password: String = "Contraseña_1",
    var isPasswordValid: Boolean = false,
    var passwordErrorMsg: Int = R.string.empty_string,

    var passwordValidate: String = "Contraseña_1",
    var isPasswordValidateValid: Boolean = false,
    var passwordValidateErrorMsg: Int = R.string.empty_string,

    var isEnabledCreateAccountButton: Boolean = true,

    var user: User = User(),

    var gson: Gson = Gson(),

    var nextScreen: String? = null
)
