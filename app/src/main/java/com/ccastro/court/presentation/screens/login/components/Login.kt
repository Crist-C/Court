package com.ccastro.court.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.domain.models.Response
import com.ccastro.court.presentation.components.defautls.DefaultCircularProgress
import com.ccastro.court.presentation.navigation.Graph
import com.ccastro.court.presentation.screens.login.LoginViewModel

@Composable
fun Login(navHostController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {

    val state = viewModel.state

    when(val loginResponse = viewModel.loginResponse){
        Response.Loading -> {
            state.isEnabledLoginButton = false
            DefaultCircularProgress()
        }
        is Response.Success<*> -> {
            LaunchedEffect(Unit){
                navHostController.navigate(Graph.HOME){
                    navHostController.popBackStack()
                    popUpTo(Graph.AUTHENTICATION) {inclusive = true}
                }
            }
        }
        is Response.Fail<*> -> {
            state.isEnabledLoginButton = true
            Toast.makeText(LocalContext.current, "Error: " + loginResponse.exception?.message, Toast.LENGTH_LONG).show()
            viewModel.resetValues()
        }
        else -> {}
    }


}