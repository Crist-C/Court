package com.ccastro.court.presentation.screens.appPresentation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ccastro.court.presentation.screens.appPresentation.components.AppPresentationContent
import com.ccastro.court.presentation.ui.theme.CourtTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppPresentationScreen( modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {},
        content = {
                  AppPresentationContent(modifier = modifier)
        },
        bottomBar = {}
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPresentationScreenPreview() {
    CourtTheme {
        AppPresentationScreen()
    }
}