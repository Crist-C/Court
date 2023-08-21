package com.ccastro.court.presentation.screens.appPresentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppPresentationViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(AppPresentationState())
        private set


}