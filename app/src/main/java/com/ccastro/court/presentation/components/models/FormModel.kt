package com.ccastro.court.presentation.components.models

data class FormModel(
    val tittle: String = "",
    val sentence: String = "",
    val fieldList: List<FormField> = emptyList()
)
