package com.ccastro.court.presentation.screens.userOnBoarding.signup.credencials

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ccastro.court.R
import com.ccastro.court.domain.models.Response
import com.ccastro.court.domain.models.User
import com.ccastro.court.domain.use_cases.auth.AuthUseCases
import com.ccastro.court.domain.use_cases.user.UserUseCases
import com.ccastro.court.presentation.navigation.AuthNavScreens
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpCredentialsViewModel @Inject constructor(): ViewModel(){

    var state by mutableStateOf(SignUpCredentialsState())
        private set


    // -----------   LOGIC FUNCTIONS    ----------- //


    // -----------   UPDATE INPUT USER DATA FUNCTIONS   ----------- //

    fun onEmailChange(email: String) {
        state = state.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        state = state.copy(password = password)
    }

    fun onPasswordValidateChange(paswordValidate: String){
        state = state.copy(passwordValidate = paswordValidate)
    }


    // -----------   VALIDATION DATA FUNCTIONS   ----------- //

    private fun enabledCreateAccountButton() {
        state.isEnabledCreateAccountButton = state.isEmailValid && state.isPasswordValid && state.isPasswordValidateValid
    }

    fun validateEmail() {
        if(Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            state.isEmailValid = true
            state.emailErrorMsg = R.string.empty_string
        }else{
            state.isEmailValid = false
            state.emailErrorMsg = R.string.ingresa_t_email_de_forma_correcta
        }
        enabledCreateAccountButton()
    }

    fun validatePassword(){

        val passwordPattern = Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*?&#_ñÑ])[A-Za-z\\d@\$!%*?&#_ñÑ]{8,}\$")

        if(state.password.matches(passwordPattern)){
            state.isPasswordValid = true
            state.passwordErrorMsg = R.string.empty_string
        } else{
            state.isPasswordValid = false
            state.passwordErrorMsg = R.string.ingresa_una_contraseña_que_cumpla_los_requerimientos
        }
        validatePasswordConfirm()
        enabledCreateAccountButton()
    }

    fun validatePasswordConfirm(){
        if(state.passwordValidate == state.password){
            state.isPasswordValidateValid = true
            state.passwordValidateErrorMsg = R.string.empty_string
        } else{
            state.isPasswordValidateValid = false
            state.passwordValidateErrorMsg = R.string.las_contrase_as_no_coinciden
        }
        enabledCreateAccountButton()
    }

    fun nextScreen() {
        state.user = User(email = state.email, password = state.password)
        state = state.copy(
            nextScreen = AuthNavScreens.SingUpPersonalInformation.passUserCredentials(
                user = state.gson.toJson(state.user)
            )
        )
    }

}