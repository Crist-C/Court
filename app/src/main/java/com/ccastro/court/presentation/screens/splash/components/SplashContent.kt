package com.ccastro.court.presentation.screens.splash.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ccastro.court.presentation.ui.theme.CourtTheme

@Composable
fun SplashContent( modifier: Modifier = Modifier) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashContentPreview() {
    CourtTheme {
        SplashContent()
    }
}