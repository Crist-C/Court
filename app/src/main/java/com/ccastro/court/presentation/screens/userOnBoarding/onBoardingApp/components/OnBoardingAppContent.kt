package com.ccastro.court.presentation.screens.userOnBoarding.onBoardingApp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ccastro.court.R
import com.ccastro.court.core.Constans
import com.ccastro.court.presentation.components.defaults.CustomPositionDots
import com.ccastro.court.presentation.components.defaults.DefaultButton
import com.ccastro.court.presentation.navigation.Graph
import com.ccastro.court.presentation.screens.userOnBoarding.onBoardingApp.OnBoardingAppViewModel
import com.ccastro.court.presentation.ui.theme.CourtTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingAppContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: OnBoardingAppViewModel = hiltViewModel()) {

    val state = viewModel.state
    val pagerState = viewModel.state.pagerState
    val scope = rememberCoroutineScope()

    BoxWithConstraints(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize(),
    ) {


        HorizontalPager(
            count = state.imagePresentationList.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()

        ) {

            BoxWithConstraints(
                modifier = modifier
                    .fillMaxSize(),
            ) {

                Image(
                    painter = painterResource(id = state.imagePresentationList[it]),
                    contentDescription = stringResource(R.string.presentation_images_content_description),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = when(it) {
                        0 -> Arrangement.Bottom
                        1 -> Arrangement.Center
                        2 -> Arrangement.Top
                        else -> Arrangement.Top
                    },
                    horizontalAlignment = when(it) {
                        0 -> Alignment.End
                        1 -> Alignment.Start
                        2 -> Alignment.Start
                        else -> Alignment.End
                    }

                ) {
                    when (it) {
                        0 -> {
                            Text(
                                modifier = Modifier.padding(end = 12.dp, bottom = 132.dp),
                                text = "Se\ntú\nmismo",
                                style = MaterialTheme.typography.displayMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                textAlign = TextAlign.Start
                            )
                        }
                        1 -> {
                            Text(
                                modifier = Modifier.padding(start = 12.dp),
                                text = "Encuentra\nlo que\nVerdaderamente\nte identifica",
                                style = MaterialTheme.typography.displaySmall,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                textAlign = TextAlign.Start
                            )
                        }
                        2 -> {
                            Text(
                                modifier = Modifier.padding(start = 12.dp, top = 12.dp),
                                text = "Y\nHazlo tuyo",
                                style = MaterialTheme.typography.displayMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                textAlign = TextAlign.Start
                            )
                        }
                        else -> {
                            Text(
                                modifier = Modifier.padding(end = 12.dp, top = 32.dp),
                                text = "CREA\ntu propia\nidentidad",
                                style = MaterialTheme.typography.displaySmall,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White,
                                textAlign = TextAlign.End
                            )
                        }

                    }

                }
            }

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

            DefaultButton(
                modifier.padding(16.dp),
                text = "Continue",
                onClick = {
                    if(state.pagerState.currentPage == state.imagePresentationList.size -1) {
                        Log.e(Constans.TAG, "NavigateTo From onBoarding to: ${Graph.AUTHENTICATION}")
                        navHostController.navigate(Graph.AUTHENTICATION) {
                            navHostController.popBackStack()
                            popUpTo(Graph.INTRODUCE)
                        }
                    } else {
                        scope.launch {
                            viewModel.nextPagerView()
                        }
                    }
                },
                enable = true
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPresentationContentPreview() {
    CourtTheme {
        OnBoardingAppContent(navHostController = rememberNavController())
    }
}