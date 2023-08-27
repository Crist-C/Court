package com.ccastro.court.presentation.components.models

import androidx.compose.ui.graphics.vector.ImageVector

data class FormField(
    val name: String,
    var value: String,
    val icon: ImageVector,
    val errorMessage: Int,
    val lambdaSetValue: (String) -> Unit,
    val lambdaValidateValue: () -> Unit
)