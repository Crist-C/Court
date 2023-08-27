package com.ccastro.court.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ccastro.court.R
import com.ccastro.court.presentation.ui.theme.CourtTheme

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = R.drawable.fondo_app), contentDescription = "app background")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeContentPreview() {
    CourtTheme {
        HomeContent()
    }
}