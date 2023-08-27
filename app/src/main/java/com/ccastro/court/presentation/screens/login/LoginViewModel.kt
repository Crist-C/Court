package com.ccastro.court.presentation.screens.login

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ccastro.court.R
import com.ccastro.court.domain.models.Response
import com.ccastro.court.domain.use_cases.auth.AuthUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {

    // Login State
    var state by mutableStateOf(LoginState())
        private set

    // Login Response
    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)

    init {
        state.currentUser = authUseCases.getCurrentUser()
        if (state.currentUser != null){   // SESIÓN INICIADA - INGRESA DIRECTAMENTE PORQUE YA EXISTE UN USUARIO LOGUEADO
            loginResponse = Response.Success(state.currentUser)
        }
    }

    // Login coroutine
    fun login() = viewModelScope.launch {
        loginResponse = Response.Loading
        val result = authUseCases.login(email = state.email, password = state.password)
        loginResponse = result
    }

    // Modificación de los campos en el formulario
    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    // Validaciones del formulario
    private fun enabledLoginButton() {
        state.isEnabledLoginButton = state.isEmailValid && state.isPasswordValid
    }

    fun validateEmail() {
        if(Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            state.isEmailValid = true
            state.emailErrorMsg = R.string.empty_string
        }else{
            state.isEmailValid = false
            state.emailErrorMsg = R.string.ingresa_t_email_de_forma_correcta
        }
        enabledLoginButton()
    }

    fun validatePassword(){
        if(state.password.length >= 6){
            state.isPasswordValid = true
            state.passwordErrorMsg = R.string.empty_string
        } else{
            state.isPasswordValid = false
            //state.passwordErrorMsg = "al menos 6 caracteres"
        }
        enabledLoginButton()
    }

    fun resetValues(){
        loginResponse = null
    }

}