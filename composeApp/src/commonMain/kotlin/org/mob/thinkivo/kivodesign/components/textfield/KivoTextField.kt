package org.mob.thinkivo.kivodesign.components.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.mob.thinkivo.kivodesign.theme.KivoTheme

/**
 * KivoTextField provides consistent text field styling across platforms.
 * Supports default, error states and leading/trailing icons.
 */
@Composable
fun KivoTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    placeholder: String? = null,
    label: String? = null,
    isError: Boolean = false,
    supportingText: String? = null,
) {
    Column(modifier = modifier) {
        // Label
        if (label != null) {
            Text(
                text = label,
                style = KivoTheme.typography.LabelMedium,
                color = if (isError) KivoTheme.colors.error else KivoTheme.colors.onSurfaceVariant,
                modifier = Modifier.padding(bottom = KivoTheme.spacing.xs),
            )
        }

        // Text Field
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            readOnly = readOnly,
            placeholder =
                if (placeholder != null) {
                    {
                        Text(
                            text = placeholder,
                            style = KivoTheme.typography.BodyMedium,
                            color = KivoTheme.colors.onSurfaceVariant,
                        )
                    }
                } else {
                    null
                },
            isError = isError,
            shape = RoundedCornerShape(8.dp),
            colors =
                TextFieldDefaults.colors(
                    focusedIndicatorColor = if (isError) KivoTheme.colors.error else KivoTheme.colors.primary,
                    unfocusedIndicatorColor = if (isError) KivoTheme.colors.error else KivoTheme.colors.outline,
                    errorIndicatorColor = KivoTheme.colors.error,
                ),
        )

        // Supporting Text
        if (supportingText != null) {
            Text(
                text = supportingText,
                style = KivoTheme.typography.Caption,
                color = if (isError) KivoTheme.colors.error else KivoTheme.colors.onSurfaceVariant,
                modifier = Modifier.padding(start = KivoTheme.spacing.m, top = KivoTheme.spacing.xs),
            )
        }
    }
}

/**
 * Text field color configuration
 */
data class KivoTextFieldColors(
    val textColor: Color,
    val disabledTextColor: Color,
    val containerColor: Color,
    val disabledContainerColor: Color,
    val cursorColor: Color,
    val focusedBorderColor: Color,
    val unfocusedBorderColor: Color,
    val disabledBorderColor: Color,
    val errorColor: Color,
    val iconColor: Color,
    val disabledIconColor: Color,
    val labelColor: Color,
    val disabledLabelColor: Color,
    val placeholderColor: Color,
    val disabledPlaceholderColor: Color,
    val supportingTextColor: Color,
    val disabledSupportingTextColor: Color,
)

/**
 * Default values for KivoTextField
 */
object KivoTextFieldDefaults {
    /**
     * Creates default colors for text field
     */
    @Composable
    fun colors(
        textColor: Color = KivoTheme.colors.onSurface,
        disabledTextColor: Color = KivoTheme.colors.onSurface.copy(alpha = 0.38f),
        containerColor: Color = KivoTheme.colors.surface,
        disabledContainerColor: Color = KivoTheme.colors.surface.copy(alpha = 0.12f),
        cursorColor: Color = KivoTheme.colors.primary,
        focusedBorderColor: Color = KivoTheme.colors.primary,
        unfocusedBorderColor: Color = KivoTheme.colors.outline,
        disabledBorderColor: Color = KivoTheme.colors.outline.copy(alpha = 0.12f),
        errorColor: Color = KivoTheme.colors.error,
        iconColor: Color = KivoTheme.colors.onSurfaceVariant,
        disabledIconColor: Color = KivoTheme.colors.onSurface.copy(alpha = 0.38f),
        labelColor: Color = KivoTheme.colors.onSurfaceVariant,
        disabledLabelColor: Color = KivoTheme.colors.onSurface.copy(alpha = 0.38f),
        placeholderColor: Color = KivoTheme.colors.onSurfaceVariant,
        disabledPlaceholderColor: Color = KivoTheme.colors.onSurface.copy(alpha = 0.38f),
        supportingTextColor: Color = KivoTheme.colors.onSurfaceVariant,
        disabledSupportingTextColor: Color = KivoTheme.colors.onSurface.copy(alpha = 0.38f),
    ): KivoTextFieldColors =
        KivoTextFieldColors(
            textColor = textColor,
            disabledTextColor = disabledTextColor,
            containerColor = containerColor,
            disabledContainerColor = disabledContainerColor,
            cursorColor = cursorColor,
            focusedBorderColor = focusedBorderColor,
            unfocusedBorderColor = unfocusedBorderColor,
            disabledBorderColor = disabledBorderColor,
            errorColor = errorColor,
            iconColor = iconColor,
            disabledIconColor = disabledIconColor,
            labelColor = labelColor,
            disabledLabelColor = disabledLabelColor,
            placeholderColor = placeholderColor,
            disabledPlaceholderColor = disabledPlaceholderColor,
            supportingTextColor = supportingTextColor,
            disabledSupportingTextColor = disabledSupportingTextColor,
        )
}
