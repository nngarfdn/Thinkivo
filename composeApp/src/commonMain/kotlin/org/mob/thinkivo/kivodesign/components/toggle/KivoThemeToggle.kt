package org.mob.thinkivo.kivodesign.components.toggle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.mob.thinkivo.kivodesign.theme.KivoTheme

/**
 * KivoThemeToggle provides a toggle switch for light/dark theme.
 *
 * @param isDarkTheme Current theme state
 * @param onThemeChange Callback when theme is toggled
 * @param modifier Modifier to be applied to the toggle
 * @param showLabel Whether to show the theme label text
 */
@Composable
fun KivoThemeToggle(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    showLabel: Boolean = true,
) {
    Row(
        modifier = modifier.padding(horizontal = KivoTheme.spacing.m),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(KivoTheme.spacing.s),
    ) {
        // Light mode icon
        Icon(
            imageVector = Icons.Default.LightMode,
            contentDescription = "Light mode",
            tint = if (!isDarkTheme) KivoTheme.colors.primary else KivoTheme.colors.onSurfaceVariant,
        )

        // Theme toggle switch
        Switch(
            checked = isDarkTheme,
            onCheckedChange = onThemeChange,
        )

        // Dark mode icon
        Icon(
            imageVector = Icons.Default.DarkMode,
            contentDescription = "Dark mode",
            tint = if (isDarkTheme) KivoTheme.colors.primary else KivoTheme.colors.onSurfaceVariant,
        )

        // Optional label
        if (showLabel) {
            Text(
                text = if (isDarkTheme) "Dark" else "Light",
                style = KivoTheme.typography.LabelMedium,
                color = KivoTheme.colors.onSurface,
            )
        }
    }
}
