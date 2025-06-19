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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import org.mob.thinkivo.kivodesign.theme.KivoTheme

/**
 * Sample composable demonstrating KivoTextField usage based on the design image
 */
@Composable
fun KivoTextFieldSample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Header
        Text(
            text = "Text Field Components",
            style = KivoTheme.typography.H4,
            color = KivoTheme.colors.onSurface
        )

        // Default Section
        TextFieldSection(
            title = "Default",
            content = {
                DefaultTextFields()
            }
        )

        // Right Icon Section
        TextFieldSection(
            title = "Right Icon",
            content = {
                RightIconTextFields()
            }
        )

        // Left Icon Section
        TextFieldSection(
            title = "Left Icon",
            content = {
                LeftIconTextFields()
            }
        )
    }
}

@Composable
private fun TextFieldSection(
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
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
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
        placeholder = "Placeholder",
        modifier = Modifier.fillMaxWidth()
    )

    // Focused with content
    KivoTextField(
        value = focusedText,
        onValueChange = { focusedText = it },
        placeholder = "Placeholder",
        modifier = Modifier.fillMaxWidth()
    )

    // Disabled
    KivoTextField(
        value = disabledText,
        onValueChange = { disabledText = it },
        placeholder = "Placeholder",
        enabled = false,
        modifier = Modifier.fillMaxWidth()
    )

    // Error state
    KivoTextField(
        value = errorText,
        onValueChange = { errorText = it },
        placeholder = "Placeholder",
        isError = true,
        supportingText = "How dare you!",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun RightIconTextFields() {
    var defaultText by remember { mutableStateOf("") }
    var focusedText by remember { mutableStateOf("Sample text") }
    var disabledText by remember { mutableStateOf("") }
    var errorText by remember { mutableStateOf("") }

    // Default with dropdown icon
    KivoTextField(
        value = defaultText,
        onValueChange = { defaultText = it },
        placeholder = "Placeholder",
        trailingIcon = Icons.Default.ArrowDropDown,
        modifier = Modifier.fillMaxWidth()
    )

    // Focused with dropdown icon
    KivoTextField(
        value = focusedText,
        onValueChange = { focusedText = it },
        placeholder = "Placeholder",
        trailingIcon = Icons.Default.ArrowDropDown,
        modifier = Modifier.fillMaxWidth()
    )

    // Disabled with dropdown icon
    KivoTextField(
        value = disabledText,
        onValueChange = { disabledText = it },
        placeholder = "Placeholder",
        trailingIcon = Icons.Default.ArrowDropDown,
        enabled = false,
        modifier = Modifier.fillMaxWidth()
    )

    // Error state with dropdown icon
    KivoTextField(
        value = errorText,
        onValueChange = { errorText = it },
        placeholder = "Placeholder",
        trailingIcon = Icons.Default.ArrowDropDown,
        isError = true,
        supportingText = "How dare you!",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun LeftIconTextFields() {
    var defaultText by remember { mutableStateOf("") }
    var focusedText by remember { mutableStateOf("Sample text") }
    var disabledText by remember { mutableStateOf("") }
    var errorText by remember { mutableStateOf("") }

    // Default with leading dropdown icon
    KivoTextField(
        value = defaultText,
        onValueChange = { defaultText = it },
        placeholder = "Placeholder",
        leadingIcon = Icons.Default.ArrowDropDown,
        modifier = Modifier.fillMaxWidth()
    )

    // Focused with leading dropdown icon
    KivoTextField(
        value = focusedText,
        onValueChange = { focusedText = it },
        placeholder = "Placeholder",
        leadingIcon = Icons.Default.ArrowDropDown,
        modifier = Modifier.fillMaxWidth()
    )

    // Disabled with leading dropdown icon
    KivoTextField(
        value = disabledText,
        onValueChange = { disabledText = it },
        placeholder = "Placeholder",
        leadingIcon = Icons.Default.ArrowDropDown,
        enabled = false,
        modifier = Modifier.fillMaxWidth()
    )

    // Error state with leading dropdown icon
    KivoTextField(
        value = errorText,
        onValueChange = { errorText = it },
        placeholder = "Placeholder",
        leadingIcon = Icons.Default.ArrowDropDown,
        isError = true,
        supportingText = "How dare you!",
        modifier = Modifier.fillMaxWidth()
    )
}

/**
 * Additional usage examples
 */
@Composable
fun KivoTextFieldUsageExamples() {
    var searchText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var emailText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Search field
        KivoTextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = "Search...",
            leadingIcon = Icons.Default.Search,
            trailingIcon = if (searchText.isNotEmpty()) Icons.Default.Clear else null,
            onTrailingIconClick = if (searchText.isNotEmpty()) {
                { searchText = "" }
            } else null,
            label = "Search",
            modifier = Modifier.fillMaxWidth()
        )

        // Password field
        KivoTextField(
            value = passwordText,
            onValueChange = { passwordText = it },
            placeholder = "Enter password",
            label = "Password",
            trailingIcon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
            onTrailingIconClick = { passwordVisible = !passwordVisible },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        // Email field with validation
        KivoTextField(
            value = emailText,
            onValueChange = { emailText = it },
            placeholder = "Enter email address",
            label = "Email",
            isError = emailText.isNotEmpty() && !emailText.contains("@"),
            supportingText = if (emailText.isNotEmpty() && !emailText.contains("@")) {
                "Please enter a valid email address"
            } else {
                "We'll never share your email"
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
