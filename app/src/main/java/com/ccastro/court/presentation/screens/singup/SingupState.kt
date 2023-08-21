package com.ccastro.court.presentation.screens.singup

import com.ccastro.court.domain.models.User


data class SingupState(

    var name: String = "",
    var isNameValid: Boolean = false,
    var nameErrorMsg: String = "",

    var email: String = "",
    var isEmailValid: Boolean = false,
    var emailErrorMsg: String = "",

    var password: String = "",
    var isPasswordValid: Boolean = false,
    var passwordErrorMsg: String = "",

    var passwordValidate: String = "",
    var isPasswordValidateValid: Boolean = false,
    var passwordValidateErrorMsg: String = "",

    var isEnabledSingupButton: Boolean = false,

    var user: User = User()
)
