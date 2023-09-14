package com.ccastro.court.presentation.components.animations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

@Composable
fun ShowAnimatedText(wordsToShow: List<String>, function: (Boolean, List<String>) -> Unit) {

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
            function(false, listOf(currentWordOne, currentWordTwo, currentWordThree))
            delay(100)
        }
        delay(300)
        for (char in wordsToShow[1]) {
            currentWordTwo += char
            function(false, listOf(currentWordOne, currentWordTwo, currentWordThree))
            delay(100)
        }
        delay(300)
        for (char in wordsToShow[2]) {
            currentWordThree += char
            function(false, listOf(currentWordOne, currentWordTwo, currentWordThree))
            delay(100)
        }
        delay(300)
        function(true, listOf(currentWordOne, currentWordTwo, currentWordThree))
    }
}