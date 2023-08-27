package com.ccastro.court.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.presentation.screens.home.components.HomeContent
import com.ccastro.court.presentation.ui.theme.CourtTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    Scaffold (
        topBar = {},
        content = {
            HomeContent()
        },
        bottomBar = {}
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    CourtTheme {
        HomeScreen(navHostController = rememberNavController())
    }
}