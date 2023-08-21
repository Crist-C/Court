package com.ccastro.court.presentation.screens.splash.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ccastro.court.R
import com.ccastro.court.presentation.ui.theme.CourtTheme

@Composable
fun SplashContent( modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.logo)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.logo_image_content_description),
            Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashContentPreview() {
    CourtTheme {
        SplashContent()
    }
}