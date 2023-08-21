package com.ccastro.court.presentation.screens.appPresentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccastro.court.R
import com.ccastro.court.presentation.components.CustomPositionDots
import com.ccastro.court.presentation.screens.appPresentation.AppPresentationViewModel
import com.ccastro.court.presentation.ui.theme.CourtTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AppPresentationContent( modifier: Modifier = Modifier, viewModel: AppPresentationViewModel = hiltViewModel()) {

    val state = viewModel.state
    val pagerState = rememberPagerState(initialPage = 0)
    val scope = rememberCoroutineScope()

    BoxWithConstraints(
        modifier = Modifier
            .background(Color.Black)
            .padding(bottom = 40.dp)
            .fillMaxSize(),
    ) {

        HorizontalPager(
            count = state.imagePresentationList.size,
            state = pagerState,
            contentPadding = PaddingValues((0).dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = state.imagePresentationList[it]),
                contentDescription = stringResource(R.string.presentation_images_content_description),
                contentScale = ContentScale.FillBounds
            )
        }
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CustomPositionDots(
                size = state.imagePresentationList.size,
                currentPage = pagerState.currentPage,
            ) {
                    clickedPage ->
                scope.launch {
                    pagerState.animateScrollToPage(page = clickedPage)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPresentationContentPreview() {
    CourtTheme {
        AppPresentationContent()
    }
}