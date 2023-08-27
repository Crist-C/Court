package com.ccastro.court.presentation.screens.appPresentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ccastro.court.R
import com.ccastro.court.presentation.components.defautls.CustomPositionDots
import com.ccastro.court.presentation.screens.appPresentation.AppPresentationViewModel
import com.ccastro.court.presentation.ui.theme.CourtTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AppPresentationContent2(modifier: Modifier = Modifier) {


    val scope = rememberCoroutineScope()
    val pagerState = PagerState(0)

    BoxWithConstraints(
        modifier = modifier
            .background(color = Color(0xFF5D5FEF))
            .padding(bottom = 40.dp)
            .fillMaxSize(),
    ) {

        HorizontalPager(
            count = 4,
            state = pagerState,
            contentPadding = PaddingValues((0).dp),
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = when(it) {
                    0 -> Arrangement.Top
                    1 -> Arrangement.Center
                    2 -> Arrangement.Center
                    else -> Arrangement.Bottom
                },
                horizontalAlignment = when(it) {
                    1 -> Alignment.Start
                    2 -> Alignment.End
                    else -> Alignment.CenterHorizontally
                }

            ) {
                when (it) {
                    0 -> {
                        Text(
                            modifier = Modifier.padding(start = 0.dp, top = 80.dp),
                            text = "Se TÚ mismo",
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White
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
                            modifier = Modifier.padding(end = 12.dp, top = 0.dp),
                            text = "Y\nHazlo\nTuyo",
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            textAlign = TextAlign.End
                        )
                    }
                    else -> {
                        Text(
                            modifier = Modifier.padding(start = 0.dp, bottom = 72.dp),
                            text = "o CREA tu propia\nidentidad",
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
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
                size = 4,
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
fun AppPresentationContentPreview2() {
    CourtTheme {
        AppPresentationContent2()
    }
}