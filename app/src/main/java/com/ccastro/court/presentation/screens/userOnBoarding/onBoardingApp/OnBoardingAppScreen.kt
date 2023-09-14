package com.ccastro.court.presentation.screens.userOnBoarding.onBoardingApp

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.presentation.screens.userOnBoarding.onBoardingApp.components.OnBoardingAppContent
import com.ccastro.court.presentation.ui.theme.CourtTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OnBoardingAppScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    Scaffold (
        topBar = {},
        content = {
            OnBoardingAppContent(modifier = modifier, navHostController = navHostController)
        },
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPresentationScreenPreview() {
    CourtTheme {
        OnBoardingAppScreen(navHostController = rememberNavController())
    }
}