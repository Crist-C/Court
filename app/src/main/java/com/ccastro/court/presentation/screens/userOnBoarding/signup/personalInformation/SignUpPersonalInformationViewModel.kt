package com.ccastro.court.presentation.screens.userOnBoarding.signup.personalInformation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ccastro.court.R
import com.ccastro.court.core.Constans.TAG
import com.ccastro.court.core.Utils.countWords
import com.ccastro.court.domain.models.Country
import com.ccastro.court.domain.models.Response
import com.ccastro.court.domain.models.User
import com.ccastro.court.domain.use_cases.auth.AuthUseCases
import com.ccastro.court.domain.use_cases.user.UserUseCases
import com.google.firebase.auth.FirebaseUser
import com.google.gson.reflect.TypeToken
import com.google.i18n.phonenumbers.PhoneNumberUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpPersonalInformationViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    var state by mutableStateOf(SignUpPersonalInformationState())
        private set

    // SingUp Response
    var signUpResponse by mutableStateOf<Response<FirebaseUser>?>(null)


    // User Credentials information gotten
    val userJson = savedStateHandle.get<String>("user")

    // Countries
    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries


    // -----------   LOGIC FUNCTIONS    ----------- //
    init {
        state.user = state.gson.fromJson(userJson, object : TypeToken<User>(){})
        Log.e(TAG, "User: $userJson")

        loadCountries()
    }

    private fun loadCountries() {
        // Aquí debes cargar la lista de países con sus datos (bandera, nombre, indicativo)
        // Puedes cargar estos datos desde recursos, una API, o cualquier otra fuente
        val countryList = listOf(
            Country(name = "Colombia", dialCode = "(+57)", flagResId = R.drawable.colombia, code = "CO"),
            Country(name = "Estados Unidos", dialCode = "(+1)", flagResId = R.drawable.estados_unidos, code = "US"),
            Country(name = "España", dialCode = "(+51)", flagResId = R.drawable.espana, code = "ES"),
            Country(name = "Mexico", dialCode = "(+52)", flagResId = R.drawable.bandera, code = "MX"),
            // Agrega los países aquí
        )
        _countries.value = countryList
        state = state.copy(
            countryList = countryList,
            country = countryList[0]
        )
    }

    fun onClickSignup(){
        state.user = state.user.copy(
            name = state.name,
            lastName = state.lastName,
            country = state.country.name,
            phone = state.phone,
        )
        state = state.copy(formEnabled = false)
        signUp(state.user)
    }

    private fun signUp(user: User) = viewModelScope.launch {
        // initial value
        signUpResponse = Response.Loading
        val result = authUseCases.singUp(user, state.user.password)
        signUpResponse = result
    }

    fun createUser() = viewModelScope.launch{
        state.user.id = authUseCases.getCurrentUser()!!.uid
        userUseCases.createUser(state.user)
    }

    fun habilitarFormulario() {
        state = state.copy(formEnabled = true)
    }

    // -----------   UPDATE INPUT USER DATA FUNCTIONS   ----------- //

    fun onNameChange(name: String){
        state = state.copy(name = name)
    }

    fun onLastNameChange(lastName: String) {
        state = state.copy(lastName = lastName)
    }

    fun onPhoneChange(phone: String) {
        if (phone.isDigitsOnly()){
            state = state.copy(phone = phone)
        }
    }

    fun onCountryChange(country: Country) {
        state = state.copy(
            country = country
        )
        state.isCountryValid = true
        validatePhone()
    }

    // -----------   VALIDATION DATA FUNCTIONS   ----------- //

    private fun enabledSignUpButton() {
        state.isEnabledSignUpButton = state.isNameValid && state.isLastNameValid && state.isPhoneValid && state.isCountryValid
    }

    fun validateUserName() {

        if (state.name.matches(Regex("^[A-Za-z]+(?:\\s[A-Za-z]+)*$")))
            when(countWords(state.name)) {
                0 -> {
                    state.isNameValid = false
                    state.nameErrorMsg = R.string.ingresa_al_menos_un_nombre
                }
                1, 2 -> {
                    state.isNameValid = true
                    state.nameErrorMsg = R.string.empty_string
                }
                else -> {
                    state.isNameValid = false
                    state.nameErrorMsg = R.string.ingresa_un_nombre_valido
                }
            }
        else {
            state.isNameValid = false
            state.nameErrorMsg = R.string.ingresa_un_nombre_valido
        }

        enabledSignUpButton()
    }

    fun validateLastName() {

        if (state.lastName.matches(Regex("^[A-Za-z]+(?:\\s[A-Za-z]+)*$")))
            when(countWords(state.lastName)) {
                0 -> {
                    state.isLastNameValid = false
                    state.lastNameErrorMsg = R.string.ingresa_al_menos_un_apellido
                }
                1, 2 -> {
                    state.isLastNameValid = true
                    state.lastNameErrorMsg = R.string.empty_string
                }
                else -> {
                    state.isLastNameValid = false
                    state.lastNameErrorMsg = R.string.ingresa_un_nombre_valido
                }
            }
        else {
            state.isLastNameValid = false
            state.lastNameErrorMsg = R.string.ingresa_un_nombre_valido
        }
        enabledSignUpButton()
    }

    fun validatePhone() {
        if (state.phone.length >= 6 && state.phone.isDigitsOnly()){
            if (isPhoneNumberValid(state.phone, state.country.code)) {
                state.isPhoneValid = true
                state = state.copy(
                    phoneErrorMsg = R.string.empty_string
                )
            }else {
                state.isPhoneValid = false
                state = state.copy(
                    phoneErrorMsg = R.string.numero_de_telefono_no_valido
                )
            }
        }else{
            state.isPhoneValid = false
        }
        enabledSignUpButton()
    }

    private fun isPhoneNumberValid(phoneNumber: String, countryCode: String): Boolean {
        // Elimina cualquier carácter que no sea un dígito o un signo más al principio
         //val cleanedPhoneNumber = PhoneNumberUtils.stripSeparators(phoneNumber)

        // Verifica si el número de teléfono es válido para el código de país proporcionado
        return try {
            val phoneNumberUtil = PhoneNumberUtil.getInstance()
            val parsedNumber = phoneNumberUtil.parse(phoneNumber, countryCode)
            val result = phoneNumberUtil.isValidNumber(parsedNumber)
            Log.i(TAG, "isPhoneNumberValid: $result")
            result
        } catch (e: NumberFormatException) {
            // Error al analizar el número
            false
        }
    }

}