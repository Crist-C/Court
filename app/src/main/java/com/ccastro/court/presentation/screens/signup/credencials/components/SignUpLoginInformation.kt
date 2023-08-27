package com.ccastro.court.presentation.screens.signup.credencials.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.R
import com.ccastro.court.presentation.components.defautls.DefaultButton
import com.ccastro.court.presentation.components.defautls.DefaultEnunciado
import com.ccastro.court.presentation.components.defautls.DefaultTextField
import com.ccastro.court.presentation.screens.signup.credencials.SignUpCredentialsViewModel

@Composable
fun SignUpLoginInformation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: SignUpCredentialsViewModel = hiltViewModel(),
    onClickFunction: () -> Unit
) {

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
                titleText = stringResource(R.string.CREATE_YOUR_ACCOUNT),
                titleStyle = MaterialTheme.typography.headlineMedium,
                sentenceText = stringResource(R.string.por_favor_ingresa_tus_datos_para_continuar),
                sentenceStyle = MaterialTheme.typography.titleSmall
            )
            DefaultTextField(
                label = stringResource(R.string.email),
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
                label = stringResource(R.string.password),
                icon = Icons.Default.Lock,
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
                label = stringResource(R.string.confirmar_contraseña),
                icon = Icons.Default.Lock,
                hideText = true,
                value = state.passwordValidate,
                onValueChange = {viewModel.onPasswordValidateChange(it)},
                onValidateData = {viewModel.validatePasswordConfirm()},
                errorMsg = state.passwordValidateErrorMsg
            )
            DefaultButton(
                modifier = Modifier.padding(start = 28.dp, end = 28.dp, top = 28.dp),
                text = stringResource(R.string.crear_mi_cuenta),
                onClick ={ onClickFunction.invoke() },
                enable = state.isEnabledCreateAccountButton
            )
            DefaultButton(
                modifier = Modifier.padding(start = 28.dp, end = 28.dp, bottom = 28.dp),
                text = stringResource(R.string.iniciar_sesion),
                colors = ButtonDefaults.outlinedButtonColors(),
                onClick = {navHostController.popBackStack()}
            )
        }
    }

}