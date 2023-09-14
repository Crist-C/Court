package com.ccastro.court.presentation.components.defaults

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomPositionDots(
    modifier: Modifier = Modifier,
    size: Int,
    currentPage: Int,
    function: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ){
        repeat(size) {
            val colorBox = if (currentPage == it) {
                Color.DarkGray
            } else {
                Color.LightGray
            }
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(CircleShape)
                    .size(16.dp)
                    .background(colorBox)
                    .clickable {
                        function.invoke(it)
                    }
            ) {

            }
        }
    }
}