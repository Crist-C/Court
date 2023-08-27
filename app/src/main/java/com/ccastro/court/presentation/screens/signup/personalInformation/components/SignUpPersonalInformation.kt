package com.ccastro.court.presentation.screens.signup.personalInformation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.R
import com.ccastro.court.presentation.components.defautls.DefaultButton
import com.ccastro.court.presentation.components.defautls.DefaultEnunciado
import com.ccastro.court.presentation.components.defautls.DefaultTextField
import com.ccastro.court.presentation.screens.signup.credencials.SignUpCredentialsViewModel

@Composable
fun SignUpPersonalInformation(
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
                titleText = stringResource(R.string.finaliza_tu_registro_title),
                titleStyle = MaterialTheme.typography.headlineMedium,
                sentenceText = stringResource(id = R.string.por_favor_ingresa_tus_datos_para_continuar),
                sentenceStyle = MaterialTheme.typography.titleSmall
            )
            DefaultTextField(
                label = stringResource(R.string.nombres_input_field_text),
                icon = Icons.Rounded.AccountCircle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                value = state.name,
                onValueChange = {viewModel.onNameChange(it)},
                onValidateData = {viewModel.validateUserName()},
                errorMsg = state.nameErrorMsg
            )
            DefaultTextField(
                label = stringResource(R.string.apellidos_input_fiel_text),
                icon = Icons.Rounded.Person,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                value = state.lastName,
                onValueChange = {viewModel.onLastNameChange(it)},
                onValidateData = {viewModel.validateLastName()},
                errorMsg = state.lastNameErrorMsg
            )
            DefaultTextField(
                label = stringResource(R.string.pais_input_field_text),
                icon = Icons.Default.Add,
                hideText = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                value = state.country,
                onValueChange = {viewModel.onCountryChange(it)},
                onValidateData = {viewModel.validateCountry()},
                errorMsg = state.countryErrorMsg
            )
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                label = stringResource(R.string.celular),
                icon = Icons.Default.Phone,
                hideText = false,
                keyboardType = KeyboardType.Number,
                value = state.phone,
                onValueChange = {viewModel.onPhoneChange(it)},
                onValidateData = {viewModel.validatePhone()},
                errorMsg = state.phoneErrorMsg
            )
            DefaultButton(
                modifier = Modifier.padding(start = 28.dp, end = 28.dp, top = 28.dp),
                text = stringResource(R.string.finalizar),
                onClick ={ onClickFunction.invoke() },
                enable = state.isEnabledSignUpButton
            )
            DefaultButton(
                modifier = Modifier.padding(start = 28.dp, end = 28.dp, bottom = 28.dp),
                text = stringResource(id = R.string.iniciar_sesion),
                colors = ButtonDefaults.outlinedButtonColors(),
                onClick = {navHostController.popBackStack()}
            )
        }
    }
}