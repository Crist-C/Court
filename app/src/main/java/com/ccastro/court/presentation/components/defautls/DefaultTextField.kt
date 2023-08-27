package com.ccastro.court.presentation.components.defautls


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ccastro.court.R
import com.ccastro.court.presentation.ui.theme.CourtTheme


@Composable
fun DefaultTextField (
    modifier: Modifier,
    label: String,
    icon: ImageVector,
    hideText: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    value: String,
    onValueChange: (value: String) -> Unit,
    onValidateData: (value: String) -> Unit = {},
    errorMsg: Int? = R.string.empty_string,
    enable : Boolean = true
){
    Column {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = {onValueChange(it)
                            onValidateData(it)},
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            enabled = enable,
            label = {
                Text(text = label)
            },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.secondary
                )
            },
            visualTransformation = if(hideText) PasswordVisualTransformation() else VisualTransformation.None,
        )
        Text(
            modifier = modifier.padding(top = 2.dp),
            text = stringResource(id = errorMsg!!),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultTextFieldPreview() {
    val name = "Cristian"
    CourtTheme {
        DefaultTextField(
            modifier = Modifier,
            label = "Nombre",
            icon = Icons.Default.AccountCircle,
            value = name,
            onValueChange = {}
        )
    }
}