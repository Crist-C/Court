package com.ccastro.court.presentation.screens.splash

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ccastro.court.presentation.screens.splash.components.SplashContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashScreen(modifier: Modifier = Modifier){
    Scaffold (
        topBar = {},
        content = {
                  SplashContent(modifier = modifier)
        },
        bottomBar = {}
    )
}