package com.ccastro.court.presentation.screens.splash

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.presentation.screens.splash.components.NavigateTo
import com.ccastro.court.presentation.screens.splash.components.SplashContent
import com.ccastro.court.presentation.ui.theme.CourtTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashScreen(modifier: Modifier = Modifier, navHostController: NavHostController){
    Scaffold (
        topBar = {},
        content = {
            SplashContent(modifier = modifier)
        },
        bottomBar = {}
    )
    NavigateTo(navHostController = navHostController)
}

@Preview( showSystemUi = true, showBackground = true)
@Composable
fun SplashScreenPreview() {
    CourtTheme {
        SplashScreen(navHostController = rememberNavController())
    }
}