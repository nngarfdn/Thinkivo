package org.mob.thinkivo.kivodesign.components.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
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
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        // Title with green accent
        Text(
            text = "Contained",
            style = KivoTheme.typography.H4,
            color = KivoTheme.colors.onSurface,
            modifier = Modifier.padding(start = KivoTheme.spacing.xs)
        )

        // Default Section
        ContainedTextFieldSection(
            title = "Default",
            content = {
                DefaultContainedFields()
            }
        )

        // Right Icon Section
        ContainedTextFieldSection(
            title = "Right Icon",
            content = {
                RightIconContainedFields()
            }
        )

        // Left Icon Section
        ContainedTextFieldSection(
            title = "Left Icon",
            content = {
                LeftIconContainedFields()
            }
        )
    }
}

@Composable
private fun ContainedTextFieldSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = title,
            style = KivoTheme.typography.H6,
            color = KivoTheme.colors.onSurface
        )
        
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            content()
        }
    }
}

@Composable
private fun DefaultContainedFields() {
    var normalState by remember { mutableStateOf("") }
    var focusedState by remember { mutableStateOf("") }
    var disabledState by remember { mutableStateOf("") }
    var errorState by remember { mutableStateOf("") }

    // Normal state
    KivoTextField(
        value = normalState,
        onValueChange = { normalState = it },
        placeholder = "Placeholder",
        modifier = Modifier.fillMaxWidth()
    )

    // Focused state (with blue border)
    KivoTextField(
        value = focusedState,
        onValueChange = { focusedState = it },
        placeholder = "Placeholder",
        modifier = Modifier.fillMaxWidth()
    )

    // Disabled state
    KivoTextField(
        value = disabledState,
        onValueChange = { disabledState = it },
        placeholder = "Placeholder",
        enabled = false,
        modifier = Modifier.fillMaxWidth()
    )

    // Error state
    KivoTextField(
        value = errorState,
        onValueChange = { errorState = it },
        placeholder = "Placeholder",
        isError = true,
        supportingText = "How dare you!",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun RightIconContainedFields() {
    var normalState by remember { mutableStateOf("") }
    var focusedState by remember { mutableStateOf("") }
    var disabledState by remember { mutableStateOf("") }
    var errorState by remember { mutableStateOf("") }

    // Normal state with right icon
    KivoTextField(
        value = normalState,
        onValueChange = { normalState = it },
        placeholder = "Placeholder",
        trailingIcon = Icons.Default.ArrowDropDown,
        modifier = Modifier.fillMaxWidth()
    )

    // Focused state with right icon
    KivoTextField(
        value = focusedState,
        onValueChange = { focusedState = it },
        placeholder = "Placeholder",
        trailingIcon = Icons.Default.ArrowDropDown,
        modifier = Modifier.fillMaxWidth()
    )

    // Disabled state with right icon
    KivoTextField(
        value = disabledState,
        onValueChange = { disabledState = it },
        placeholder = "Placeholder",
        trailingIcon = Icons.Default.ArrowDropDown,
        enabled = false,
        modifier = Modifier.fillMaxWidth()
    )

    // Error state with right icon
    KivoTextField(
        value = errorState,
        onValueChange = { errorState = it },
        placeholder = "Placeholder",
        trailingIcon = Icons.Default.ArrowDropDown,
        isError = true,
        supportingText = "How dare you!",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun LeftIconContainedFields() {
    var normalState by remember { mutableStateOf("") }
    var focusedState by remember { mutableStateOf("") }
    var disabledState by remember { mutableStateOf("") }
    var errorState by remember { mutableStateOf("") }

    // Normal state with left icon
    KivoTextField(
        value = normalState,
        onValueChange = { normalState = it },
        placeholder = "Placeholder",
        leadingIcon = Icons.Default.ArrowDropDown,
        modifier = Modifier.fillMaxWidth()
    )

    // Focused state with left icon
    KivoTextField(
        value = focusedState,
        onValueChange = { focusedState = it },
        placeholder = "Placeholder",
        leadingIcon = Icons.Default.ArrowDropDown,
        modifier = Modifier.fillMaxWidth()
    )

    // Disabled state with left icon
    KivoTextField(
        value = disabledState,
        onValueChange = { disabledState = it },
        placeholder = "Placeholder",
        leadingIcon = Icons.Default.ArrowDropDown,
        enabled = false,
        modifier = Modifier.fillMaxWidth()
    )

    // Error state with left icon
    KivoTextField(
        value = errorState,
        onValueChange = { errorState = it },
        placeholder = "Placeholder",
        leadingIcon = Icons.Default.ArrowDropDown,
        isError = true,
        supportingText = "How dare you!",
        modifier = Modifier.fillMaxWidth()
    )
}
