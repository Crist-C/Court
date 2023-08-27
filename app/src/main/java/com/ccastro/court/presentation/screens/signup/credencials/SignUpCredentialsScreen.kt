package com.ccastro.court.presentation.screens.signup.credencials

import android.annotation.SuppressLint
import android.view.WindowManager
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.presentation.components.defautls.EditKeyBoardUiMode
import com.ccastro.court.presentation.ui.theme.CourtTheme
import com.ccastro.court.presentation.screens.signup.components.Singup
import com.ccastro.court.presentation.screens.signup.credencials.components.SignUpCredentialsContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpCredentialsScreen(navHostController: NavHostController) {

    @Suppress("DEPRECATION")
    (EditKeyBoardUiMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE))

    Scaffold (
        topBar = {
        },
        content = {
          SignUpCredentialsContent(navHostController)
        },
        bottomBar = {}
    )

    Singup(navHostController = navHostController)

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpCredentialsScreenPreview(){
    CourtTheme() {
        SignUpCredentialsScreen(navHostController = rememberNavController())
    }
}