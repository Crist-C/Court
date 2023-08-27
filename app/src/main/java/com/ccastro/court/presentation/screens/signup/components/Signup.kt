package com.ccastro.court.presentation.screens.signup.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.domain.models.Response
import com.ccastro.court.presentation.components.defautls.DefaultCircularProgress
import com.ccastro.court.presentation.navigation.AuthNavScreens
import com.ccastro.court.presentation.navigation.Graph
import com.ccastro.court.presentation.screens.signup.credencials.SignUpCredentialsViewModel

@Composable
fun Singup(navHostController: NavHostController, viewModel: SignUpCredentialsViewModel = hiltViewModel()){
    when(val singupResponse = viewModel.signUpResponse){
        is Response.Fail ->{
            Toast.makeText(LocalContext.current, singupResponse.exception?.message, Toast.LENGTH_LONG).show()
            viewModel.signUpResponse = null
        }
        Response.Loading -> {
            DefaultCircularProgress()
        }
        is Response.Success -> {
            LaunchedEffect(Unit){
                viewModel.createUser()
                navHostController.navigate(AuthNavScreens.Login.route){
                    popUpTo(Graph.AUTHENTICATION) {inclusive = true}
                }
            }
        }
        else -> {}
    }
}