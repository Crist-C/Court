package com.ccastro.court.presentation.screens.appPresentation

import com.ccastro.court.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState


data class AppPresentationState @OptIn(ExperimentalPagerApi::class) constructor(

    val pagerState: PagerState = PagerState(0),

    val imagePresentationList: List<Int> = listOf(
        R.drawable.se_tu_mismo_op3,
        R.drawable.encuentra,
        R.drawable.hazlo_tuyo,
        R.drawable.creala_op3
    )

)
