package com.ccastro.court.presentation.screens.userOnBoarding.onBoardingApp

import com.ccastro.court.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState


data class OnBoardingAppState @OptIn(ExperimentalPagerApi::class) constructor(

    val pagerState: PagerState = PagerState(0),

    val imagePresentationList: List<Int> = listOf(
        R.drawable.se_tu_mismo_op3,
        R.drawable.encuentra,
        R.drawable.hazlo_tuyo,
        R.drawable.creala_op3
    )

)
