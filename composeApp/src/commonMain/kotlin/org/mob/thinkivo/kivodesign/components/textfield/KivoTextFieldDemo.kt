package org.mob.thinkivo.kivodesign.components.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
 * Demo showcasing KivoTextField exactly like the design image with "Contained" sections
 */
@Composable
fun KivoTextFieldDemo() {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        // Title with green accent
        Text(
            text = "Contained",
            style = KivoTheme.typography.H4,
            color = KivoTheme.colors.onSurface,
            modifier = Modifier.padding(start = KivoTheme.spacing.xs),
        )

        // Default Section
        ContainedTextFieldSection(
            title = "Default",
            content = {
                DefaultContainedFields()
            },
        )
    }
}

@Composable
private fun ContainedTextFieldSection(
    title: String,
    content: @Composable () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = title,
            style = KivoTheme.typography.H6,
            color = KivoTheme.colors.onSurfaceVariant,
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            content()
        }
    }
}

@Composable
private fun DefaultContainedFields() {
    var normalState by remember { mutableStateOf("") }
    var focusedState by remember { mutableStateOf("Sample text") }
    var disabledState by remember { mutableStateOf("") }
    var errorState by remember { mutableStateOf("Sample error text") }

    // Normal state
    KivoTextField(
        value = normalState,
        onValueChange = { normalState = it },
        placeholder = "Placeholder",
        modifier = Modifier.fillMaxWidth(),
    )

    // Focused state (with blue border)
    KivoTextField(
        value = focusedState,
        onValueChange = { focusedState = it },
        placeholder = "Placeholder",
        modifier = Modifier.fillMaxWidth(),
    )

    // Disabled state
    KivoTextField(
        value = disabledState,
        onValueChange = { disabledState = it },
        placeholder = "Placeholder",
        enabled = false,
        modifier = Modifier.fillMaxWidth(),
    )

    // Error state
    KivoTextField(
        value = errorState,
        onValueChange = { errorState = it },
        placeholder = "Placeholder",
        isError = true,
        supportingText = "Error message text",
        modifier = Modifier.fillMaxWidth(),
    )
}
