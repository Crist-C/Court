package com.ccastro.court.presentation.screens.splash.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccastro.court.R
import com.ccastro.court.presentation.screens.splash.SplashViewModel
import com.ccastro.court.presentation.ui.theme.CourtTheme
import kotlinx.coroutines.delay

@SuppressLint("UnrememberedMutableState")
@Composable
fun SplashContent( modifier: Modifier = Modifier, viewModel: SplashViewModel = hiltViewModel()) {
    val image = painterResource(id = R.drawable.logo)
    val wordsToShow = listOf("FIND","YOUR","STYLE")
    var currentWordOne by remember {
        mutableStateOf("")
    }
    var currentWordTwo by remember {
        mutableStateOf("")
    }
    var currentWordThree by remember {
        mutableStateOf("")
    }

    LaunchedEffect(key1 = true) {
        for (char in wordsToShow[0]) {
            currentWordOne += char
            delay(100)
        }
        delay(300)
        for (char in wordsToShow[1]) {
            currentWordTwo += char
            delay(100)
        }
        delay(300)
        for (char in wordsToShow[2]) {
            currentWordThree += char
            delay(100)
        }
        delay(300)
        viewModel.validateUserIsLoged()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(start = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = currentWordOne,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.displayLarge.fontSize
        )
        Text(
            text = currentWordTwo,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.displayLarge.fontSize
        )
        Text(
            text = currentWordThree,
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.displayLarge.fontSize
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