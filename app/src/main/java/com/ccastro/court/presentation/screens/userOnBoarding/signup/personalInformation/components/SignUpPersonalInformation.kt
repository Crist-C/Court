package com.ccastro.court.presentation.screens.userOnBoarding.signup.personalInformation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.R
import com.ccastro.court.domain.models.Country
import com.ccastro.court.presentation.components.defaults.DefaultButton
import com.ccastro.court.presentation.components.defaults.DefaultEnunciado
import com.ccastro.court.presentation.components.defaults.DefaultTextField
import com.ccastro.court.presentation.navigation.Graph
import com.ccastro.court.presentation.screens.userOnBoarding.signup.personalInformation.SignUpPersonalInformationViewModel
import com.ccastro.court.presentation.ui.theme.CourtTheme

@Composable
fun SignUpPersonalInformation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: SignUpPersonalInformationViewModel = hiltViewModel(),
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
                errorMsg = state.nameErrorMsg,
                enable = state.formEnabled
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
                errorMsg = state.lastNameErrorMsg,
                enable = state.formEnabled

            )
            CountryDropdownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp ),
                items = state.countryList,
                onItemSelected = {
                    viewModel.onCountryChange(it)
                },
                enable = state.formEnabled
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
                errorMsg = state.phoneErrorMsg,
                enable = state.formEnabled
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
                onClick = {navHostController.navigate(Graph.AUTHENTICATION){
                    navHostController.popBackStack()
                } }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryDropdownMenu(
    modifier: Modifier = Modifier,
    items: List<Country>,
    onItemSelected: (Country) -> Unit,
    enable: Boolean = true
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedItem by remember {
        mutableStateOf(items[0])
    }
    Box(modifier = modifier
    ) {
        ExposedDropdownMenuBox(
            modifier = Modifier.fillMaxSize(),
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {

            OutlinedTextField(
                label = { Text(text = stringResource(R.string.country))},
                value = selectedItem.name,
                onValueChange = {},
                readOnly = true,
                leadingIcon = {Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = selectedItem.flagResId),
                    contentDescription = "country flag"
                )},
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)},
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                enabled = enable
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                items.forEach {
                    country ->
                    DropdownMenuItem(

                        leadingIcon = {
                            Image(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = country.flagResId),
                            contentDescription = "country flag")
                        },

                        text = {
                            Text(text = country.name)
                        },

                        onClick = {
                        selectedItem = country
                        expanded = false
                        onItemSelected(country)
                        }
                    )
                }
            }
        }


    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CountryDropdownMenuPreview() {
    val countryList = listOf(
        Country(name = "Colombia", dialCode = "(+57)", flagResId = R.drawable.colombia, code = "COL"),
        Country(name = "Unit Estates", dialCode = "(+1)", flagResId = R.drawable.estados_unidos, code = "USA"),
        Country(name = "España", dialCode = "(+51)", flagResId = R.drawable.espana, code = "ESP"),
        Country(name = "Mexico", dialCode = "(+52)", flagResId = R.drawable.bandera, code = "MEX"),
        // Agrega los países aquí
    )

    CourtTheme {
        CountryDropdownMenu(
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp), items = countryList, onItemSelected = {})
    }
}
