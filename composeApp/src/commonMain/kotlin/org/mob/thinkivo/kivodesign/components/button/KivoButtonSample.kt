package org.mob.thinkivo.kivodesign.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Sample composable demonstrating KivoButton usage
 */
@Composable
fun KivoButtonSample() {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        // Filled Buttons Section
        Text(
            text = "Fill",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp),
        )

        FilledButtonsRow()

        Spacer(modifier = Modifier.height(8.dp))

        // Outlined Buttons Section
        Text(
            text = "Outline",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp),
        )

        OutlinedButtonsRow()

        Spacer(modifier = Modifier.height(16.dp))

        // Different Color Variants
        Text(
            text = "Color Variants",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp),
        )

        ColorVariantsSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Disabled States
        Text(
            text = "Disabled States",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 8.dp),
        )

        DisabledButtonsSection()
    }
}

@Composable
private fun FilledButtonsRow() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        // Large buttons row
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            KivoButton(
                text = "Button",
                onClick = { },
                size = KivoButtonSize.ExtraLarge,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                size = KivoButtonSize.ExtraLarge,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Trailing,
                size = KivoButtonSize.ExtraLarge,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Leading,
                size = KivoButtonSize.ExtraLarge,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Trailing,
                size = KivoButtonSize.ExtraLarge,
            )

            KivoIconButton(
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                size = KivoButtonSize.IconLarge,
            )

            KivoButton(
                text = "L",
                onClick = { },
                size = KivoButtonSize.IconLarge,
            )

            KivoButton(
                text = "12",
                onClick = { },
                size = KivoButtonSize.IconLarge,
            )
        }

        // Medium buttons row
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            KivoButton(
                text = "Button",
                onClick = { },
                size = KivoButtonSize.Large,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                size = KivoButtonSize.Large,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Trailing,
                size = KivoButtonSize.Large,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Leading,
                size = KivoButtonSize.Large,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Trailing,
                size = KivoButtonSize.Large,
            )

            KivoIconButton(
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                size = KivoButtonSize.IconMedium,
            )

            KivoButton(
                text = "L",
                onClick = { },
                size = KivoButtonSize.IconMedium,
            )

            KivoButton(
                text = "12",
                onClick = { },
                size = KivoButtonSize.IconMedium,
            )
        }

        // Small buttons row
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            KivoButton(
                text = "Button",
                onClick = { },
                size = KivoButtonSize.Medium,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                size = KivoButtonSize.Medium,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Trailing,
                size = KivoButtonSize.Medium,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Leading,
                size = KivoButtonSize.Medium,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Trailing,
                size = KivoButtonSize.Medium,
            )

            KivoIconButton(
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                size = KivoButtonSize.IconSmall,
            )

            KivoButton(
                text = "M",
                onClick = { },
                size = KivoButtonSize.IconSmall,
            )

            KivoButton(
                text = "12",
                onClick = { },
                size = KivoButtonSize.IconSmall,
            )
        }

        // Extra small buttons row
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            KivoButton(
                text = "Button",
                onClick = { },
                size = KivoButtonSize.Small,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                size = KivoButtonSize.Small,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Trailing,
                size = KivoButtonSize.Small,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Leading,
                size = KivoButtonSize.Small,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                iconPosition = KivoIconPosition.Trailing,
                size = KivoButtonSize.Small,
            )

            KivoIconButton(
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                size = KivoButtonSize.IconSmall,
            )

            KivoButton(
                text = "S",
                onClick = { },
                size = KivoButtonSize.IconSmall,
            )

            KivoButton(
                text = "12",
                onClick = { },
                size = KivoButtonSize.IconSmall,
            )
        }
    }
}

@Composable
private fun OutlinedButtonsRow() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        // Large outlined buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            KivoButton(
                text = "Button",
                onClick = { },
                style = KivoButtonStyle.Outlined,
                size = KivoButtonSize.ExtraLarge,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                style = KivoButtonStyle.Outlined,
                size = KivoButtonSize.ExtraLarge,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                style = KivoButtonStyle.Outlined,
                iconPosition = KivoIconPosition.Trailing,
                size = KivoButtonSize.ExtraLarge,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                style = KivoButtonStyle.Outlined,
                iconPosition = KivoIconPosition.Leading,
                size = KivoButtonSize.ExtraLarge,
            )

            KivoTextIconButton(
                text = "Button",
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                style = KivoButtonStyle.Outlined,
                iconPosition = KivoIconPosition.Trailing,
                size = KivoButtonSize.ExtraLarge,
            )

            KivoIconButton(
                icon = Icons.Default.Favorite,
                contentDescription = "Favorite",
                onClick = { },
                style = KivoButtonStyle.Outlined,
                size = KivoButtonSize.IconLarge,
            )

            KivoButton(
                text = "L",
                onClick = { },
                style = KivoButtonStyle.Outlined,
                size = KivoButtonSize.IconLarge,
            )

            KivoButton(
                text = "12",
                onClick = { },
                style = KivoButtonStyle.Outlined,
                size = KivoButtonSize.IconLarge,
            )
        }

        // Add similar rows for other sizes with outlined style...
        // (Similar structure as filled buttons but with style = KivoButtonStyle.Outlined)
    }
}

@Composable
private fun ColorVariantsSection() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        KivoButton(
            text = "Primary",
            onClick = { },
            colors = KivoButtonDefaults.colors(),
        )

        KivoButton(
            text = "Danger",
            onClick = { },
            colors = KivoButtonDefaults.dangerColors(),
        )

        KivoButton(
            text = "Success",
            onClick = { },
            colors = KivoButtonDefaults.successColors(),
        )

        KivoButton(
            text = "Warning",
            onClick = { },
            colors = KivoButtonDefaults.warningColors(),
        )

        KivoButton(
            text = "Secondary",
            onClick = { },
            colors = KivoButtonDefaults.secondaryColors(),
        )
    }
}

@Composable
private fun DisabledButtonsSection() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        KivoButton(
            text = "Disabled",
            onClick = { },
            enabled = false,
        )

        KivoButton(
            text = "Disabled",
            onClick = { },
            style = KivoButtonStyle.Outlined,
            enabled = false,
        )

        KivoTextIconButton(
            text = "Disabled",
            icon = Icons.Default.Favorite,
            contentDescription = "Favorite",
            onClick = { },
            enabled = false,
        )

        KivoIconButton(
            icon = Icons.Default.Favorite,
            contentDescription = "Favorite",
            onClick = { },
            enabled = false,
        )
    }
}
