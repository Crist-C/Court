package com.ccastro.court.presentation.screens.signup.credencials

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ccastro.court.R
import com.ccastro.court.domain.models.Response
import com.ccastro.court.domain.models.User
import com.ccastro.court.domain.use_cases.auth.AuthUseCases
import com.ccastro.court.domain.use_cases.user.UserUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpCredentialsViewModel @Inject constructor(private val authUseCases: AuthUseCases, private val userUseCases: UserUseCases): ViewModel(){

    var state by mutableStateOf(SignUpCredentialsState())
        private set

    // SingUp Response
    var signUpResponse by mutableStateOf<Response<FirebaseUser>?>(null)


    // -----------   LOGIC FUNCTIONS    ----------- //
    /*
    private fun signFormData() : FormModel {
        return FormModel(
            tittle = "REGISTRO",
            sentence = "Por favor ingresa tus datos para continuar",
            fieldList = listOf(
                FormField(name = "Email", value = state.email, icon = Icons.Default.Email, errorMessage = state.emailErrorMsg , { onEmailChange(it) }) { validateEmail() },
                FormField("Password", state.email ,Icons.Default.Lock, state.passwordErrorMsg, { onPasswordChange(it) } ) { validatePassword()},
                FormField("Confirm Password", state.passwordValidate, Icons.Default.Lock, state.passwordValidateErrorMsg, { onPasswordValidateChange(it) } ) { validatePasswordConfirm() }
            )
        )
    }

    fun personalFormData() : FormModel {
        return FormModel(
            tittle = "REGISTRO",
            sentence = "Por favor ingresa tus datos para continuar",
            fieldList = listOf(
                FormField("Name", state.name, Icons.Default.Person, state.nameErrorMsg, { it -> onNameChange(it) }) { validateUserName() },
                FormField("Last Name", state.lastName, Icons.Default.Person, state.lastNameErrorMsg, { onNameChange(it) } ) { validateUserName()},
                FormField("Phone number", state.phone, Icons.Default.Phone, state.phoneErrorMsg, { onPhoneChange(it) } ) { validatePhone() }
            )
        )
    }
    */

    fun onClickSignup(){
        state.user = state.user.copy(
            //username = state.name,
            email = state.email
        )
        singup(state.user)
    }

    fun singup(user: User) = viewModelScope.launch {
        // Valor inicial
        signUpResponse = Response.Loading
        val result = authUseCases.singUp(user, state.password)
        signUpResponse = result
    }

    fun createUser() = viewModelScope.launch{
        state.user.id = authUseCases.getCurrentUser()!!.uid
        userUseCases.create(state.user)
    }


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
        if(state.password.length >= 6){
            state.isPasswordValid = true
            state.passwordErrorMsg = R.string.empty_string
        } else{
            state.isPasswordValid = false
            state.passwordErrorMsg = R.string.ingresa_una_contraseña_que_cumpla_los_requerimientos
        }
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

}