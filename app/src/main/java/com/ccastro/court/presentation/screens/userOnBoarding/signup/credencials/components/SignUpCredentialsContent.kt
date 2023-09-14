package com.ccastro.court.presentation.screens.userOnBoarding.signup.credencials.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.presentation.screens.userOnBoarding.signup.credencials.SignUpCredentialsViewModel
import com.ccastro.court.presentation.ui.theme.CourtTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SignUpCredentialsContent(
    navHostController: NavHostController,
    viewModel: SignUpCredentialsViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        //LogoMaasComponent(modifier = Modifier.padding(bottom = 0.dp))

        SignUpLoginInformation(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
            navHostController = navHostController
        ) {
            viewModel.nextScreen()
        }

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SingUpCredentialsContentPreview() {
    CourtTheme {
        SignUpCredentialsContent(navHostController = rememberNavController())
    }
}