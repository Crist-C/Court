package com.ccastro.court.presentation.screens.signup.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.presentation.components.defautls.DefaultButton
import com.ccastro.court.presentation.components.defautls.DefaultEnunciado
import com.ccastro.court.presentation.components.defautls.DefaultTextField
import com.ccastro.court.presentation.screens.signup.credencials.SignUpCredentialsViewModel

@Composable
fun SignUpFieldsCard(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: SignUpCredentialsViewModel = hiltViewModel(),
){

    val state = viewModel.state

    Surface(
        modifier = modifier
            .wrapContentSize(),
        shape = ShapeDefaults.Small,
        shadowElevation = 8.dp,
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DefaultEnunciado(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 20.dp),
                titleText = "REGISTRO",
                titleStyle = MaterialTheme.typography.headlineMedium,
                sentenceText = "Por favor ingresa tus datos para continuar",
                sentenceStyle = MaterialTheme.typography.titleSmall
            )
            DefaultTextField(
                label = "Nombre completo",
                icon = Icons.Default.Email,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                value = state.name,
                onValueChange = {viewModel.onNameChange(it)},
                onValidateData = {viewModel.validateUserName()},
                errorMsg = state.nameErrorMsg
            )
            DefaultTextField(
                label = "Correo electrónico",
                icon = Icons.Default.Email,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                value = state.email,
                onValueChange = {viewModel.onEmailChange(it)},
                onValidateData = {viewModel.validateEmail()},
                errorMsg = state.emailErrorMsg
            )
            DefaultTextField(
                label = "Password",
                icon = Icons.Default.Email,
                hideText = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                value = state.password,
                onValueChange = {viewModel.onPasswordChange(it)},
                onValidateData = {viewModel.validatePassword()},
                errorMsg = state.passwordErrorMsg
            )
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                label = "Confirmar Password",
                icon = Icons.Default.Email,
                hideText = true,
                value = state.passwordValidate,
                onValueChange = {viewModel.onPasswordValidateChange(it)},
                onValidateData = {viewModel.validatePasswordConfirm()},
                errorMsg = state.passwordValidateErrorMsg
            )
            DefaultButton(
                modifier = Modifier.padding(start = 28.dp, end = 28.dp, top = 28.dp),
                text = "REGISTRARME",
                onClick ={ viewModel.onClickSignup()},
                enable = state.isEnabledSignUpButton
            )
            DefaultButton(
                modifier = Modifier.padding(start = 28.dp, end = 28.dp, bottom = 28.dp),
                text = "INICIAR SESIÓN",
                colors = ButtonDefaults.outlinedButtonColors(),
                onClick = {navHostController.popBackStack()}
            )
        }
    }

}