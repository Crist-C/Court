package com.ccastro.court.presentation.screens.userOnBoarding.signup.personalInformation

import com.ccastro.court.R
import com.ccastro.court.domain.models.Country
import com.ccastro.court.domain.models.User
import com.google.gson.Gson


data class SignUpPersonalInformationState(

    var name: String = "Cristian",
    var isNameValid: Boolean = false,
    var nameErrorMsg: Int = R.string.empty_string,

    var lastName: String = "Castro",
    var isLastNameValid: Boolean = false,
    var lastNameErrorMsg: Int = R.string.empty_string,

    var countryList: List<Country> = emptyList(),
    var country: Country = Country(R.drawable.colombia, "Colombia", "57", "CO"),
    var isCountryValid: Boolean = false,
    var countryErrorMsg: Int = R.string.empty_string,

    var phone: String = "3003409417",
    var isPhoneValid: Boolean = false,
    var phoneErrorMsg: Int = R.string.empty_string,

    var isEnabledSignUpButton: Boolean = true,
    var formEnabled: Boolean = true,

    var user: User = User(),
    var gson: Gson = Gson()

)
