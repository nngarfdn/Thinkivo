package org.mob.thinkivo.kivodesign.components.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.mob.thinkivo.kivodesign.theme.KivoTheme

/**
 * Sample composable demonstrating KivoTextField usage based on the design image
 */
@Composable
fun KivoTextFieldSample() {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        // Header
        Text(
            text = "Text Field Components",
            style = KivoTheme.typography.H4,
            color = KivoTheme.colors.onSurface,
        )

        // Default Section
        TextFieldSection(
            title = "Default",
            content = {
                DefaultTextFields()
            },
        )
    }
}

@Composable
private fun TextFieldSection(
    title: String,
    content: @Composable () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = title,
            style = KivoTheme.typography.H6,
            color = KivoTheme.colors.onSurface,
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                content()
            }
        }
    }
}

@Composable
private fun DefaultTextFields() {
    var defaultText by remember { mutableStateOf("") }
    var focusedText by remember { mutableStateOf("Sample text") }
    var disabledText by remember { mutableStateOf("") }
    var errorText by remember { mutableStateOf("") }

    // Default unfocused
    KivoTextField(
        value = defaultText,
        onValueChange = { defaultText = it },
        placeholder = "Enter text...",
        label = "Default Text Field",
        modifier = Modifier.fillMaxWidth(),
    )

    // Focused state
    KivoTextField(
        value = focusedText,
        onValueChange = { focusedText = it },
        placeholder = "Enter text...",
        label = "Focused Text Field",
        modifier = Modifier.fillMaxWidth(),
    )

    // Disabled state
    KivoTextField(
        value = disabledText,
        onValueChange = { disabledText = it },
        placeholder = "Enter text...",
        label = "Disabled Text Field",
        enabled = false,
        modifier = Modifier.fillMaxWidth(),
    )

    // Error state
    KivoTextField(
        value = errorText,
        onValueChange = { errorText = it },
        placeholder = "Enter text...",
        label = "Error Text Field",
        isError = true,
        supportingText = "This field has an error",
        modifier = Modifier.fillMaxWidth(),
    )
}
