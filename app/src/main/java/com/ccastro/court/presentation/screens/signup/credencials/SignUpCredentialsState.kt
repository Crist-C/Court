package com.ccastro.court.presentation.screens.signup.credencials

import com.ccastro.court.R
import com.ccastro.court.domain.models.User
import com.ccastro.court.presentation.components.models.FormModel


data class SignUpCredentialsState(

    var email: String = "",
    var isEmailValid: Boolean = false,
    var emailErrorMsg: Int = R.string.empty_string,

    var password: String = "",
    var isPasswordValid: Boolean = false,
    var passwordErrorMsg: Int = R.string.empty_string,

    var passwordValidate: String = "",
    var isPasswordValidateValid: Boolean = false,
    var passwordValidateErrorMsg: Int = R.string.empty_string,

    var isEnabledCreateAccountButton: Boolean = false,

    var user: User = User(),

)
