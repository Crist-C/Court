package com.ccastro.court.presentation.screens.userOnBoarding.splash.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccastro.court.presentation.components.animations.ShowAnimatedText
import com.ccastro.court.presentation.screens.userOnBoarding.splash.SplashViewModel
import com.ccastro.court.presentation.ui.theme.CourtTheme

@SuppressLint("UnrememberedMutableState")
@Composable
fun SplashContent( modifier: Modifier = Modifier, viewModel: SplashViewModel = hiltViewModel()) {

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

    var animateFinished by remember {
        mutableStateOf(false)
    }


    ShowAnimatedText(wordsToShow) {
        stateAnimation : Boolean, words: List<String> ->
        currentWordOne = words[0]
        currentWordTwo = words[1]
        currentWordThree = words[2]
        animateFinished = stateAnimation
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

    if(animateFinished && !viewModel.state.nextScreenWasLaunched) {
        viewModel.validateUserIsLoged()
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashContentPreview() {
    CourtTheme {
        SplashContent()
    }
}