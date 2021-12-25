package com.example.heapsort.ui

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyTextField(
    value: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier,
    onDoneClick: () -> Unit, trailingIcon: @Composable () -> Unit
) {
    TextField(
        value = value,
        onValueChange = onTextChange,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        keyboardActions = KeyboardActions(onDone = { onDoneClick() }),
        trailingIcon = trailingIcon,
        maxLines = 1
    )
}
