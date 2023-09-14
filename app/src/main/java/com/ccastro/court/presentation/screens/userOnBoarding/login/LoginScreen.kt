package com.ccastro.court.presentation.screens.userOnBoarding.login

import android.annotation.SuppressLint
import android.view.WindowManager
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.presentation.screens.userOnBoarding.login.components.LoginContent
import com.ccastro.court.presentation.components.defaults.EditKeyBoardUiMode
import com.ccastro.court.presentation.screens.userOnBoarding.login.components.Login
import com.ccastro.court.presentation.ui.theme.CourtTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navHostController: NavHostController) {
    // Configuración del teclado
    EditKeyBoardUiMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)

    Scaffold(
        topBar = {},
        content = {
            LoginContent(navHostController = navHostController)
        },
        bottomBar = {}
    )
    // Login Function
    Login(navHostController = navHostController)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview() {
    CourtTheme() {
        LoginScreen(navHostController = rememberNavController())
    }
}