package com.ccastro.court.presentation.screens.appPresentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.presentation.components.DefaultButton
import com.ccastro.court.presentation.screens.appPresentation.components.AppPresentationContent
import com.ccastro.court.presentation.ui.theme.CourtTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppPresentationScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    Scaffold (
        topBar = {},
        content = {
            AppPresentationContent(modifier = modifier)
        },
        bottomBar = {
            DefaultButton(
                Modifier.padding(16.dp),
                text = "Continue",
                onClick = { },
                enable = true
            )
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPresentationScreenPreview() {
    CourtTheme {
        AppPresentationScreen(navHostController = rememberNavController())
    }
}