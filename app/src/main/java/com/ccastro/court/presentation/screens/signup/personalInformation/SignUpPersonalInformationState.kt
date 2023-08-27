package com.ccastro.court.presentation.screens.signup.personalInformation

import com.ccastro.court.R
import com.ccastro.court.domain.models.User
import com.ccastro.court.presentation.components.models.FormModel


data class SignUpPersonalInformationState(

    var name: String = "",
    var isNameValid: Boolean = false,
    var nameErrorMsg: Int = R.string.empty_string,

    var lastName: String = "",
    var isLastNameValid: Boolean = false,
    var lastNameErrorMsg: Int = R.string.empty_string,

    var country: String = "",
    var isCountryValid: Boolean = false,
    var countryErrorMsg: Int = R.string.empty_string,

    var phone: String = "",
    var isPhoneValid: Boolean = false,
    var phoneErrorMsg: Int = R.string.empty_string,

    var email: String = "",
    var isEmailValid: Boolean = false,
    var emailErrorMsg: Int = R.string.empty_string,

    var password: String = "",
    var isPasswordValid: Boolean = false,
    var passwordErrorMsg: Int = R.string.empty_string,

    var passwordValidate: String = "",
    var isPasswordValidateValid: Boolean = false,
    var passwordValidateErrorMsg: Int = R.string.empty_string,

    var isEnabledSignUpButton: Boolean = false,
    var isEnabledCreateAccountButton: Boolean = false,

    var user: User = User(),

    var singInformationForm: FormModel = FormModel(),
    var personalInformationForm: FormModel = FormModel(),

    var enableNextForm: Boolean = false,
    var totalPages: Int = 2,
    var currentTotalPage: Int = 1
)
