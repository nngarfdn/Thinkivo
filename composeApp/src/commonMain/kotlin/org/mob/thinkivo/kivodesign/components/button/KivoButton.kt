package org.mob.thinkivo.kivodesign.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.mob.thinkivo.kivodesign.tokens.ThinkivoColors

/**
 * KivoButton provides consistent button styling across platforms.
 * Supports filled and outlined variants in multiple sizes.
 *
 * @param text The button text to display
 * @param onClick Callback when button is pressed
 * @param modifier Modifier to be applied to the button
 * @param enabled Whether the button is enabled
 * @param style Visual style of the button (Filled or Outlined)
 * @param size Size variant of the button
 * @param colors Custom colors for the button
 * @param interactionSource MutableInteractionSource for handling interactions
 *
 * @sample KivoButtonSample
 */
@Composable
fun KivoButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
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

    val buttonModifier =
        modifier
            .height(size.height)
            .then(
                if (size.width != null) {
                    Modifier.width(size.width)
                } else {
                    Modifier
                },
            )

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
                Text(
                    text = text,
                    style = size.textStyle,
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
                Text(
                    text = text,
                    style = size.textStyle,
                )
            }
        }
    }
}

/**
 * Button style variants
 */
enum class KivoButtonStyle {
    Filled,
    Outlined,
}

/**
 * Button size variants based on design system
 */
sealed class KivoButtonSize(
    val height: androidx.compose.ui.unit.Dp,
    val width: androidx.compose.ui.unit.Dp? = null,
    val contentPadding: PaddingValues,
    val textStyle: TextStyle,
    val shape: Shape,
) {
    data object ExtraLarge : KivoButtonSize(
        height = 56.dp,
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
        textStyle = TextStyle(),
        shape = RoundedCornerShape(8.dp),
    )

    data object Large : KivoButtonSize(
        height = 48.dp,
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
        textStyle = TextStyle(),
        shape = RoundedCornerShape(8.dp),
    )

    data object Medium : KivoButtonSize(
        height = 40.dp,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        textStyle = TextStyle(),
        shape = RoundedCornerShape(6.dp),
    )

    data object Small : KivoButtonSize(
        height = 32.dp,
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        textStyle = TextStyle(),
        shape = RoundedCornerShape(6.dp),
    )

    // Icon-only button variants
    data object IconLarge : KivoButtonSize(
        height = 48.dp,
        width = 48.dp,
        contentPadding = PaddingValues(12.dp),
        textStyle = TextStyle(),
        shape = RoundedCornerShape(8.dp),
    )

    data object IconMedium : KivoButtonSize(
        height = 40.dp,
        width = 40.dp,
        contentPadding = PaddingValues(8.dp),
        textStyle = TextStyle(),
        shape = RoundedCornerShape(6.dp),
    )

    data object IconSmall : KivoButtonSize(
        height = 32.dp,
        width = 32.dp,
        contentPadding = PaddingValues(6.dp),
        textStyle = TextStyle(),
        shape = RoundedCornerShape(6.dp),
    )
}

/**
 * Button color configuration
 */
@Immutable
data class KivoButtonColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
)

/**
 * Default values for KivoButton
 */
object KivoButtonDefaults {
    /**
     * Creates default colors for primary button
     */
    @Composable
    fun colors(
        containerColor: Color = ThinkivoColors.Primary,
        contentColor: Color = ThinkivoColors.White,
        disabledContainerColor: Color = ThinkivoColors.Gray300,
        disabledContentColor: Color = ThinkivoColors.Gray500,
    ): KivoButtonColors =
        KivoButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    /**
     * Creates colors for danger/destructive actions
     */
    @Composable
    fun dangerColors(): KivoButtonColors =
        KivoButtonColors(
            containerColor = ThinkivoColors.Danger,
            contentColor = ThinkivoColors.White,
            disabledContainerColor = ThinkivoColors.Gray300,
            disabledContentColor = ThinkivoColors.Gray500,
        )

    /**
     * Creates colors for success actions
     */
    @Composable
    fun successColors(): KivoButtonColors =
        KivoButtonColors(
            containerColor = ThinkivoColors.Success,
            contentColor = ThinkivoColors.White,
            disabledContainerColor = ThinkivoColors.Gray300,
            disabledContentColor = ThinkivoColors.Gray500,
        )

    /**
     * Creates colors for warning actions
     */
    @Composable
    fun warningColors(): KivoButtonColors =
        KivoButtonColors(
            containerColor = ThinkivoColors.Warning,
            contentColor = ThinkivoColors.Gray900,
            disabledContainerColor = ThinkivoColors.Gray300,
            disabledContentColor = ThinkivoColors.Gray500,
        )

    /**
     * Creates colors for secondary/neutral actions
     */
    @Composable
    fun secondaryColors(): KivoButtonColors =
        KivoButtonColors(
            containerColor = ThinkivoColors.Gray200,
            contentColor = ThinkivoColors.Gray900,
            disabledContainerColor = ThinkivoColors.Gray300,
            disabledContentColor = ThinkivoColors.Gray500,
        )
}
