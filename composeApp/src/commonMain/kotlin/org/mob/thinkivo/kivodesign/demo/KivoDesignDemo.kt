package org.mob.thinkivo.kivodesign.demo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.mob.thinkivo.features.login.presentation.LoginScreen
import org.mob.thinkivo.features.login.presentation.LoginViewModel
import org.mob.thinkivo.kivodesign.components.button.KivoButton
import org.mob.thinkivo.kivodesign.components.button.KivoButtonDefaults
import org.mob.thinkivo.kivodesign.components.button.KivoButtonSize
import org.mob.thinkivo.kivodesign.components.button.KivoButtonStyle
import org.mob.thinkivo.kivodesign.components.button.KivoIconButton
import org.mob.thinkivo.kivodesign.components.button.KivoIconPosition
import org.mob.thinkivo.kivodesign.components.button.KivoTextIconButton
import org.mob.thinkivo.kivodesign.components.textfield.KivoTextFieldDemo
import org.mob.thinkivo.kivodesign.components.toggle.KivoThemeToggle
import org.mob.thinkivo.kivodesign.theme.KivoTheme
import org.mob.thinkivo.kivodesign.theme.ThemeManager

/**
 * Complete demo showcasing KivoDesign system with theme toggle
 */
@Composable
fun KivoDesignDemo() {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(top = 50.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Spacer(modifier = Modifier.height(50.dp))
//        KivoTextFieldSample()
        // Theme Control Section
        ThemeControlSection()

        // Typography Showcase
        TypographyShowcase()

        // Button Showcase
        ButtonShowcase()

        // Text Field Showcase
        TextFieldShowcase()

        // Color Palette Preview
        ColorPalettePreview()

        KivoTextFieldDemo()

        // Login Screen Demo
        val loginViewModel = remember { LoginViewModel() }
        val loginState by loginViewModel.state.collectAsState()
        LoginScreen(
            state = loginState,
            onEvent = loginViewModel::onEvent,
            enableScrolling = false,
        )
    }
}

@Composable
private fun ThemeControlSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Theme System",
                style = KivoTheme.typography.H5,
                color = KivoTheme.colors.onSurface,
            )

            Text(
                text = "Toggle between light and dark themes. All components automatically adapt to the selected theme.",
                style = KivoTheme.typography.BodyMedium,
                color = KivoTheme.colors.onSurfaceVariant,
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                KivoThemeToggle(
                    isDarkTheme = ThemeManager.isDarkTheme,
                    onThemeChange = { ThemeManager.setTheme(it) },
                    showLabel = true,
                )
            }
        }
    }
}

@Composable
private fun TypographyShowcase() {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = "Typography Scale",
                style = KivoTheme.typography.H5,
                color = KivoTheme.colors.onSurface,
            )

            Text(
                text = "Display Large",
                style = KivoTheme.typography.DisplayLarge,
                color = KivoTheme.colors.primary,
            )

            Text(
                text = "Heading 1 - Page Titles",
                style = KivoTheme.typography.H1,
                color = KivoTheme.colors.onSurface,
            )

            Text(
                text = "Heading 2 - Section Headers",
                style = KivoTheme.typography.H2,
                color = KivoTheme.colors.onSurface,
            )

            Text(
                text = "Heading 3 - Subsection Headers",
                style = KivoTheme.typography.H3,
                color = KivoTheme.colors.onSurface,
            )

            Text(
                text = "Body Large - Main content text with good readability for longer passages",
                style = KivoTheme.typography.BodyLarge,
                color = KivoTheme.colors.onSurface,
            )

            Text(
                text = "Body Medium - Standard content text for most UI elements",
                style = KivoTheme.typography.BodyMedium,
                color = KivoTheme.colors.onSurfaceVariant,
            )

            Text(
                text = "Caption - Secondary information and metadata",
                style = KivoTheme.typography.Caption,
                color = KivoTheme.colors.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun ButtonShowcase() {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = "Button Components",
                style = KivoTheme.typography.H5,
                color = KivoTheme.colors.onSurface,
            )

            // Color Variants
            Text(
                text = "Color Variants",
                style = KivoTheme.typography.H6,
                color = KivoTheme.colors.onSurface,
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                KivoButton(
                    text = "Primary",
                    onClick = { },
                    size = KivoButtonSize.Medium,
                )

                KivoButton(
                    text = "Success",
                    onClick = { },
                    colors = KivoButtonDefaults.successColors(),
                    size = KivoButtonSize.Medium,
                )

                KivoButton(
                    text = "Danger",
                    onClick = { },
                    colors = KivoButtonDefaults.dangerColors(),
                    size = KivoButtonSize.Medium,
                )

                KivoButton(
                    text = "Warning",
                    onClick = { },
                    colors = KivoButtonDefaults.warningColors(),
                    size = KivoButtonSize.Medium,
                )
            }

            // Style Variants
            Text(
                text = "Style Variants",
                style = KivoTheme.typography.H6,
                color = KivoTheme.colors.onSurface,
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                KivoButton(
                    text = "Filled",
                    onClick = { },
                    style = KivoButtonStyle.Filled,
                    size = KivoButtonSize.Medium,
                )

                KivoButton(
                    text = "Outlined",
                    onClick = { },
                    style = KivoButtonStyle.Outlined,
                    size = KivoButtonSize.Medium,
                )

                KivoButton(
                    text = "Disabled",
                    onClick = { },
                    enabled = false,
                    size = KivoButtonSize.Medium,
                )
            }

            // Icon Buttons
            Text(
                text = "Icon Buttons",
                style = KivoTheme.typography.H6,
                color = KivoTheme.colors.onSurface,
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                KivoIconButton(
                    icon = Icons.Default.Check,
                    contentDescription = "Confirm",
                    onClick = { },
                    colors = KivoButtonDefaults.successColors(),
                    size = KivoButtonSize.IconMedium,
                )

                KivoIconButton(
                    icon = Icons.Default.Delete,
                    contentDescription = "Delete",
                    onClick = { },
                    colors = KivoButtonDefaults.dangerColors(),
                    size = KivoButtonSize.IconMedium,
                )

                KivoIconButton(
                    icon = Icons.Default.Warning,
                    contentDescription = "Warning",
                    onClick = { },
                    style = KivoButtonStyle.Outlined,
                    colors = KivoButtonDefaults.warningColors(),
                    size = KivoButtonSize.IconMedium,
                )
            }

            // Text + Icon Buttons
            Text(
                text = "Text + Icon Buttons",
                style = KivoTheme.typography.H6,
                color = KivoTheme.colors.onSurface,
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    KivoTextIconButton(
                        text = "Confirm",
                        icon = Icons.Default.Check,
                        contentDescription = "Confirm",
                        onClick = { },
                        iconPosition = KivoIconPosition.Leading,
                        colors = KivoButtonDefaults.successColors(),
                        size = KivoButtonSize.Medium,
                    )

                    KivoTextIconButton(
                        text = "Delete",
                        icon = Icons.Default.Delete,
                        contentDescription = "Delete",
                        onClick = { },
                        iconPosition = KivoIconPosition.Trailing,
                        colors = KivoButtonDefaults.dangerColors(),
                        size = KivoButtonSize.Medium,
                    )
                }
            }
        }
    }
}

@Composable
private fun TextFieldShowcase() {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = "Text Field Components",
                style = KivoTheme.typography.H5,
                color = KivoTheme.colors.onSurface,
            )

            // Default Text Fields
            Text(
                text = "Default States",
                style = KivoTheme.typography.H6,
                color = KivoTheme.colors.onSurface,
            )

            // Note: For full text field functionality, use KivoTextFieldDemo
            Text(
                text = "Text fields support default, focused, disabled, and error states with optional leading/trailing icons.",
                style = KivoTheme.typography.BodyMedium,
                color = KivoTheme.colors.onSurfaceVariant,
            )

            Text(
                text = "📝 Use KivoTextFieldDemo() for interactive text field examples",
                style = KivoTheme.typography.Caption,
                color = KivoTheme.colors.primary,
            )
        }
    }
}

@Composable
private fun ColorPalettePreview() {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Color System",
                style = KivoTheme.typography.H5,
                color = KivoTheme.colors.onSurface,
            )

            Text(
                text = "Current theme colors adapting automatically:",
                style = KivoTheme.typography.BodyMedium,
                color = KivoTheme.colors.onSurfaceVariant,
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                ColorItem("Primary", KivoTheme.colors.primary)
                ColorItem("Secondary", KivoTheme.colors.secondary)
                ColorItem("Success", KivoTheme.colors.success)
                ColorItem("Warning", KivoTheme.colors.warning)
                ColorItem("Error", KivoTheme.colors.error)
                ColorItem("Background", KivoTheme.colors.background)
                ColorItem("Surface", KivoTheme.colors.surface)
            }
        }
    }
}

@Composable
private fun ColorItem(
    name: String,
    color: androidx.compose.ui.graphics.Color,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Canvas(
            modifier = Modifier.size(24.dp),
        ) {
            drawCircle(color = color)
        }

        Text(
            text = name,
            style = KivoTheme.typography.BodyMedium,
            color = KivoTheme.colors.onSurface,
        )
    }
}
