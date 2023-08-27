package com.ccastro.court.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.presentation.components.defautls.DefaultTopBar
import com.ccastro.court.presentation.screens.profile.contents.ProfileContent
import com.ccastro.court.presentation.ui.theme.CourtTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
                 DefaultTopBar(
                     title = "",
                     upAvailable = true,
                     navHostController = navHostController,
                     //backScreen = AppScreens.Home,
                     //currentScreen = AppScreens.Profile,
                 )
        },
        content = {
                  ProfileContent(navHostController)
        },
        bottomBar = {}
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfileScreenPreview(){
    CourtTheme() {
        ProfileScreen(navHostController = rememberNavController())
    }
}
