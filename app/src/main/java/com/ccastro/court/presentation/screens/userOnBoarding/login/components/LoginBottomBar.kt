package com.ccastro.court.presentation.screens.userOnBoarding.login.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.core.Constans
import com.ccastro.court.presentation.navigation.AuthNavScreens
import com.ccastro.court.presentation.ui.theme.CourtTheme

@Composable
fun LoginBottonBar(navHostController: NavHostController){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "¿Aún no tienes cuenta?",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            modifier = Modifier
                .clickable {
                    Log.e(Constans.TAG, "NavigateTo From Login to: ${AuthNavScreens.SingUpCredentials.route}")
                    navHostController.navigate(AuthNavScreens.SingUpCredentials.route)
            },
            text = "Registrate",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginBottonBarPreview(){
    CourtTheme {
        LoginBottonBar(navHostController = rememberNavController())
    }
}