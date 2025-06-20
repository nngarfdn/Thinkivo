package org.mob.thinkivo.kivodesign.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

/**
 * KivoIconButton provides consistent icon button styling across platforms.
 * Supports filled and outlined variants in multiple sizes.
 *
 * @param icon The icon to display
 * @param contentDescription Accessibility description for the icon
 * @param onClick Callback when button is pressed
 * @param modifier Modifier to be applied to the button
 * @param enabled Whether the button is enabled
 * @param style Visual style of the button (Filled or Outlined)
 * @param size Size variant of the button
 * @param colors Custom colors for the button
 * @param interactionSource MutableInteractionSource for handling interactions
 */
@Composable
fun KivoIconButton(
    icon: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: KivoButtonStyle = KivoButtonStyle.Filled,
    size: KivoButtonSize = KivoButtonSize.IconLarge,
    colors: KivoButtonColors = KivoButtonDefaults.colors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val buttonColors =
        when (style) {
            KivoButtonStyle.Filled ->
                ButtonDefaults.buttonColors(
                    containerColor = colors.containerColor,
                    contentColor = colors.contentColor,
                    disabledContainerColor = colors.disabledContainerColor,
                    disabledContentColor = colors.disabledContentColor,
                )

            KivoButtonStyle.Outlined ->
                ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = colors.containerColor,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = colors.disabledContainerColor,
                )
        }

    val border =
        when (style) {
            KivoButtonStyle.Filled -> null
            KivoButtonStyle.Outlined ->
                BorderStroke(
                    width = 1.dp,
                    color = if (enabled) colors.containerColor else colors.disabledContainerColor,
                )
        }

    val buttonModifier =
        modifier
            .size(size.height)

    when (style) {
        KivoButtonStyle.Filled -> {
            Button(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled,
                shape = size.shape,
                colors = buttonColors,
                contentPadding = size.contentPadding,
                interactionSource = interactionSource,
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier =
                        Modifier.size(
                            when (size) {
                                is KivoButtonSize.IconLarge -> 24.dp
                                is KivoButtonSize.IconMedium -> 20.dp
                                is KivoButtonSize.IconSmall -> 16.dp
                                else -> 24.dp
                            },
                        ),
                )
            }
        }

        KivoButtonStyle.Outlined -> {
            OutlinedButton(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled,
                shape = size.shape,
                colors = buttonColors,
                border = border,
                contentPadding = size.contentPadding,
                interactionSource = interactionSource,
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier =
                        Modifier.size(
                            when (size) {
                                is KivoButtonSize.IconLarge -> 24.dp
                                is KivoButtonSize.IconMedium -> 20.dp
                                is KivoButtonSize.IconSmall -> 16.dp
                                else -> 24.dp
                            },
                        ),
                )
            }
        }
    }
}

/**
 * KivoTextIconButton combines text and icon in a single button.
 * Supports both leading and trailing icon positions.
 *
 * @param text The button text to display
 * @param icon The icon to display
 * @param contentDescription Accessibility description for the icon
 * @param onClick Callback when button is pressed
 * @param modifier Modifier to be applied to the button
 * @param enabled Whether the button is enabled
 * @param iconPosition Position of the icon relative to text
 * @param style Visual style of the button (Filled or Outlined)
 * @param size Size variant of the button
 * @param colors Custom colors for the button
 * @param interactionSource MutableInteractionSource for handling interactions
 */
@Composable
fun KivoTextIconButton(
    text: String,
    icon: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    iconPosition: KivoIconPosition = KivoIconPosition.Leading,
    style: KivoButtonStyle = KivoButtonStyle.Filled,
    size: KivoButtonSize = KivoButtonSize.Large,
    colors: KivoButtonColors = KivoButtonDefaults.colors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val buttonColors =
        when (style) {
            KivoButtonStyle.Filled ->
                ButtonDefaults.buttonColors(
                    containerColor = colors.containerColor,
                    contentColor = colors.contentColor,
                    disabledContainerColor = colors.disabledContainerColor,
                    disabledContentColor = colors.disabledContentColor,
                )

            KivoButtonStyle.Outlined ->
                ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = colors.containerColor,
                    disabledContainerColor = Color.Transparent,
                    disabledContentColor = colors.disabledContainerColor,
                )
        }

    val border =
        when (style) {
            KivoButtonStyle.Filled -> null
            KivoButtonStyle.Outlined ->
                BorderStroke(
                    width = 1.dp,
                    color = if (enabled) colors.containerColor else colors.disabledContainerColor,
                )
        }

    val buttonModifier = modifier.height(size.height)

    val iconSize =
        when (size) {
            is KivoButtonSize.ExtraLarge -> 24.dp
            is KivoButtonSize.Large -> 20.dp
            is KivoButtonSize.Medium -> 18.dp
            is KivoButtonSize.Small -> 16.dp
            else -> 20.dp
        }

    when (style) {
        KivoButtonStyle.Filled -> {
            Button(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled,
                shape = size.shape,
                colors = buttonColors,
                contentPadding = size.contentPadding,
                interactionSource = interactionSource,
            ) {
                ButtonContent(
                    text = text,
                    icon = icon,
                    contentDescription = contentDescription,
                    iconPosition = iconPosition,
                    iconSize = iconSize,
                    textStyle = size.textStyle,
                )
            }
        }

        KivoButtonStyle.Outlined -> {
            OutlinedButton(
                onClick = onClick,
                modifier = buttonModifier,
                enabled = enabled,
                shape = size.shape,
                colors = buttonColors,
                border = border,
                contentPadding = size.contentPadding,
                interactionSource = interactionSource,
            ) {
                ButtonContent(
                    text = text,
                    icon = icon,
                    contentDescription = contentDescription,
                    iconPosition = iconPosition,
                    iconSize = iconSize,
                    textStyle = size.textStyle,
                )
            }
        }
    }
}

@Composable
private fun ButtonContent(
    text: String,
    icon: ImageVector,
    contentDescription: String?,
    iconPosition: KivoIconPosition,
    iconSize: androidx.compose.ui.unit.Dp,
    textStyle: androidx.compose.ui.text.TextStyle,
) {
    Row(
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
    ) {
        when (iconPosition) {
            KivoIconPosition.Leading -> {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(iconSize),
                )
                Text(
                    text = text,
                    style = textStyle,
                )
            }

            KivoIconPosition.Trailing -> {
                Text(
                    text = text,
                    style = textStyle,
                )
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(iconSize),
                )
            }
        }
    }
}

/**
 * Icon position in text+icon buttons
 */
enum class KivoIconPosition {
    Leading,
    Trailing,
}
