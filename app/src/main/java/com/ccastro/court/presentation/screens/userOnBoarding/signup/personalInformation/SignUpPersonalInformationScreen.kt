package com.ccastro.court.presentation.screens.userOnBoarding.signup.personalInformation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.presentation.screens.userOnBoarding.signup.personalInformation.components.SignUp
import com.ccastro.court.presentation.screens.userOnBoarding.signup.personalInformation.components.SignUpPersonalInformationContent
import com.ccastro.court.presentation.ui.theme.CourtTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUpPersonalInformationScreen(navHostController: NavHostController, user: String?) {

    //@Suppress("DEPRECATION")
    //(EditKeyBoardUiMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE))

    Scaffold (
        topBar = {
        },
        content = {
          SignUpPersonalInformationContent(navHostController)
        },
        bottomBar = {}
    )

    SignUp(navHostController = navHostController)

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPersonalInformationScreenPreview(){
    CourtTheme {
        SignUpPersonalInformationScreen(navHostController = rememberNavController(), "")
    }
}