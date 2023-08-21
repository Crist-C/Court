package com.ccastro.court.presentation.screens.singup

import android.annotation.SuppressLint
import android.view.WindowManager
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.presentation.components.EditKeyBoardUiMode
import com.ccastro.court.presentation.ui.theme.CourtTheme
import com.ccastro.court.presentation.screens.singup.components.Singup
import com.ccastro.court.presentation.screens.singup.components.SingupContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingupScreen(navHostController: NavHostController) {
    @Suppress("DEPRECATION")
    (EditKeyBoardUiMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE))
    Scaffold (
        topBar = {
        },
        content = {
                  SingupContent(navHostController)
        },
        bottomBar = {}
    )
    Singup(navHostController = navHostController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SingupScreenPreview(){
    CourtTheme() {
        SingupScreen(navHostController = rememberNavController())
    }
}