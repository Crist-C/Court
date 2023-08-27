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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.presentation.components.defautls.DefaultButton
import com.ccastro.court.presentation.components.defautls.DefaultEnunciado
import com.ccastro.court.presentation.components.defautls.DefaultTextField
import com.ccastro.court.presentation.components.models.FormModel
import com.ccastro.court.presentation.screens.signup.credencials.SignUpCredentialsViewModel
import com.ccastro.court.presentation.ui.theme.CourtTheme

/**
 * Formulario experimental creado a partir de los modelos
 * FormField y FormModel. No se está usando
 */
@Composable
fun SingUpFormCard(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: SignUpCredentialsViewModel = hiltViewModel(),
    formModel: FormModel
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
                titleText = formModel.tittle,
                titleStyle = MaterialTheme.typography.headlineMedium,
                sentenceText = formModel.sentence,
                sentenceStyle = MaterialTheme.typography.titleSmall
            )
            repeat(formModel.fieldList.size) {iteration ->
                DefaultTextField(
                    label = formModel.fieldList[iteration].name,
                    icon = formModel.fieldList[iteration].icon,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    value = formModel.fieldList[iteration].value,
                    onValueChange = {formModel.fieldList[iteration].lambdaSetValue(it)},
                    onValidateData = {viewModel.validateUserName()},
                    errorMsg = formModel.fieldList[iteration].errorMessage
                )
            }
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SingUpFormCardPreview() {

    CourtTheme {
        //SingUpFormCard(navHostController = rememberNavController(), formModel = singFormData())
    }
}
