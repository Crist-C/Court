package com.ccastro.court.presentation.screens.appPresentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ccastro.court.presentation.components.defautls.DefaultButton
import com.ccastro.court.presentation.navigation.Graph
import com.ccastro.court.presentation.screens.appPresentation.AppPresentationViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AppPresentationButtonContent(
    modifier: Modifier = Modifier,
    viewModel: AppPresentationViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val scope = rememberCoroutineScope()

}