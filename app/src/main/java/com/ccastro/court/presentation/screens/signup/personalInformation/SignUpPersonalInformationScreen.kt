package com.ccastro.court.presentation.screens.signup.personalInformation

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
import com.ccastro.court.presentation.screens.signup.personalInformation.components.SignUpPersonalInformationContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpPersonalInformationScreen(navHostController: NavHostController) {

    @Suppress("DEPRECATION")
    (EditKeyBoardUiMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE))

    Scaffold (
        topBar = {
        },
        content = {
          SignUpPersonalInformationContent(navHostController)
        },
        bottomBar = {}
    )

    Singup(navHostController = navHostController)

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPersonalInformationScreenPreview(){
    CourtTheme() {
        SignUpPersonalInformationScreen(navHostController = rememberNavController())
    }
}