package com.ccastro.court.presentation.screens.userOnBoarding.onBoardingApp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingAppViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(OnBoardingAppState())
        private set
    @OptIn(ExperimentalPagerApi::class)
    suspend fun nextPagerView() {
        if (state.pagerState.currentPage == state.imagePresentationList.size - 1) {

        }else {
            state.pagerState.animateScrollToPage(state.pagerState.currentPage + 1)
            //state = state.copy(
             //   pagerState = PagerState(currentPage = (state.pagerState.currentPage + 1))
            //)
        }
    }


}