package org.mob.thinkivo.kivodesign.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import org.mob.thinkivo.kivodesign.tokens.ThinkivoColors
import org.mob.thinkivo.kivodesign.tokens.ThinkivoTypography

/**
 * KivoTheme provides consistent theming across platforms.
 * Supports light/dark themes and follows KivoDesign principles.
 *
 * @param darkTheme Whether to use dark theme
 * @param content The content to theme
 */
@Composable
fun KivoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        KivoDarkColorScheme
    } else {
        KivoLightColorScheme
    }

    val kivoColors = if (darkTheme) {
        KivoDarkColors
    } else {
        KivoLightColors
    }

    CompositionLocalProvider(
        LocalKivoColors provides kivoColors,
        LocalKivoTypography provides ThinkivoTypography,
        LocalKivoSpacing provides KivoSpacingInstance
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = createKivoTypography(),
            content = content
        )
    }
}

/**
 * Object to access KivoTheme tokens
 */
object KivoTheme {
    val colors: KivoColors
        @Composable
        get() = LocalKivoColors.current

    val typography: org.mob.thinkivo.kivodesign.tokens.ThinkivoTypography
        @Composable
        get() = LocalKivoTypography.current

    val spacing: KivoSpacingTokens
        @Composable
        get() = LocalKivoSpacing.current
}

/**
 * KivoColors provides semantic color tokens
 */
data class KivoColors(
    val primary: androidx.compose.ui.graphics.Color,
    val onPrimary: androidx.compose.ui.graphics.Color,
    val primaryContainer: androidx.compose.ui.graphics.Color,
    val onPrimaryContainer: androidx.compose.ui.graphics.Color,

    val secondary: androidx.compose.ui.graphics.Color,
    val onSecondary: androidx.compose.ui.graphics.Color,
    val secondaryContainer: androidx.compose.ui.graphics.Color,
    val onSecondaryContainer: androidx.compose.ui.graphics.Color,

    val tertiary: androidx.compose.ui.graphics.Color,
    val onTertiary: androidx.compose.ui.graphics.Color,
    val tertiaryContainer: androidx.compose.ui.graphics.Color,
    val onTertiaryContainer: androidx.compose.ui.graphics.Color,

    val error: androidx.compose.ui.graphics.Color,
    val onError: androidx.compose.ui.graphics.Color,
    val errorContainer: androidx.compose.ui.graphics.Color,
    val onErrorContainer: androidx.compose.ui.graphics.Color,

    val background: androidx.compose.ui.graphics.Color,
    val onBackground: androidx.compose.ui.graphics.Color,
    val surface: androidx.compose.ui.graphics.Color,
    val onSurface: androidx.compose.ui.graphics.Color,
    val surfaceVariant: androidx.compose.ui.graphics.Color,
    val onSurfaceVariant: androidx.compose.ui.graphics.Color,

    val outline: androidx.compose.ui.graphics.Color,
    val outlineVariant: androidx.compose.ui.graphics.Color,

    // Custom KivoDesign colors
    val success: androidx.compose.ui.graphics.Color,
    val onSuccess: androidx.compose.ui.graphics.Color,
    val successContainer: androidx.compose.ui.graphics.Color,
    val onSuccessContainer: androidx.compose.ui.graphics.Color,

    val warning: androidx.compose.ui.graphics.Color,
    val onWarning: androidx.compose.ui.graphics.Color,
    val warningContainer: androidx.compose.ui.graphics.Color,
    val onWarningContainer: androidx.compose.ui.graphics.Color
)

/**
 * KivoSpacing provides semantic spacing tokens
 */
data class KivoSpacingTokens(
    val xs: androidx.compose.ui.unit.Dp = 4.dp,
    val s: androidx.compose.ui.unit.Dp = 8.dp,
    val m: androidx.compose.ui.unit.Dp = 12.dp,
    val l: androidx.compose.ui.unit.Dp = 16.dp,
    val xl: androidx.compose.ui.unit.Dp = 20.dp,
    val xxl: androidx.compose.ui.unit.Dp = 24.dp,
    val xxxl: androidx.compose.ui.unit.Dp = 32.dp
)

// Light Color Scheme
val KivoLightColors = KivoColors(
    primary = ThinkivoColors.Primary,
    onPrimary = ThinkivoColors.White,
    primaryContainer = ThinkivoColors.PrimaryLightest,
    onPrimaryContainer = ThinkivoColors.PrimaryDark,

    secondary = ThinkivoColors.Gray600,
    onSecondary = ThinkivoColors.White,
    secondaryContainer = ThinkivoColors.Gray200,
    onSecondaryContainer = ThinkivoColors.Gray900,

    tertiary = ThinkivoColors.Layout.Purple,
    onTertiary = ThinkivoColors.White,
    tertiaryContainer = ThinkivoColors.Layout.PurpleLight,
    onTertiaryContainer = ThinkivoColors.Gray900,

    error = ThinkivoColors.Danger,
    onError = ThinkivoColors.White,
    errorContainer = ThinkivoColors.DangerLightest,
    onErrorContainer = ThinkivoColors.DangerDark,

    background = ThinkivoColors.White,
    onBackground = ThinkivoColors.Gray900,
    surface = ThinkivoColors.White,
    onSurface = ThinkivoColors.Gray900,
    surfaceVariant = ThinkivoColors.Gray100,
    onSurfaceVariant = ThinkivoColors.Gray700,

    outline = ThinkivoColors.Gray400,
    outlineVariant = ThinkivoColors.Gray300,

    success = ThinkivoColors.Success,
    onSuccess = ThinkivoColors.White,
    successContainer = ThinkivoColors.SuccessLightest,
    onSuccessContainer = ThinkivoColors.SuccessDark,

    warning = ThinkivoColors.Warning,
    onWarning = ThinkivoColors.Gray900,
    warningContainer = ThinkivoColors.WarningLightest,
    onWarningContainer = ThinkivoColors.WarningDark
)

// Dark Color Scheme
val KivoDarkColors = KivoColors(
    primary = ThinkivoColors.PrimaryLight,
    onPrimary = ThinkivoColors.Gray900,
    primaryContainer = ThinkivoColors.PrimaryDark,
    onPrimaryContainer = ThinkivoColors.PrimaryLightest,

    secondary = ThinkivoColors.Gray400,
    onSecondary = ThinkivoColors.Gray900,
    secondaryContainer = ThinkivoColors.Gray700,
    onSecondaryContainer = ThinkivoColors.Gray200,

    tertiary = ThinkivoColors.Layout.PurpleLight,
    onTertiary = ThinkivoColors.Gray900,
    tertiaryContainer = ThinkivoColors.Layout.Purple,
    onTertiaryContainer = ThinkivoColors.Gray100,

    error = ThinkivoColors.DangerLight,
    onError = ThinkivoColors.Gray900,
    errorContainer = ThinkivoColors.DangerDark,
    onErrorContainer = ThinkivoColors.DangerLightest,

    background = ThinkivoColors.Gray900,
    onBackground = ThinkivoColors.White,
    surface = ThinkivoColors.Gray800,
    onSurface = ThinkivoColors.White,
    surfaceVariant = ThinkivoColors.Gray700,
    onSurfaceVariant = ThinkivoColors.Gray300,

    outline = ThinkivoColors.Gray600,
    outlineVariant = ThinkivoColors.Gray700,

    success = ThinkivoColors.SuccessLight,
    onSuccess = ThinkivoColors.Gray900,
    successContainer = ThinkivoColors.SuccessDark,
    onSuccessContainer = ThinkivoColors.SuccessLightest,

    warning = ThinkivoColors.WarningLight,
    onWarning = ThinkivoColors.Gray900,
    warningContainer = ThinkivoColors.WarningDark,
    onWarningContainer = ThinkivoColors.WarningLightest
)

// Material 3 Color Schemes
val KivoLightColorScheme = lightColorScheme(
    primary = ThinkivoColors.Primary,
    onPrimary = ThinkivoColors.White,
    primaryContainer = ThinkivoColors.PrimaryLightest,
    onPrimaryContainer = ThinkivoColors.PrimaryDark,

    secondary = ThinkivoColors.Gray600,
    onSecondary = ThinkivoColors.White,
    secondaryContainer = ThinkivoColors.Gray200,
    onSecondaryContainer = ThinkivoColors.Gray900,

    tertiary = ThinkivoColors.Layout.Purple,
    onTertiary = ThinkivoColors.White,
    tertiaryContainer = ThinkivoColors.Layout.PurpleLight,
    onTertiaryContainer = ThinkivoColors.Gray900,

    error = ThinkivoColors.Danger,
    onError = ThinkivoColors.White,
    errorContainer = ThinkivoColors.DangerLightest,
    onErrorContainer = ThinkivoColors.DangerDark,

    background = ThinkivoColors.White,
    onBackground = ThinkivoColors.Gray900,
    surface = ThinkivoColors.White,
    onSurface = ThinkivoColors.Gray900,
    surfaceVariant = ThinkivoColors.Gray100,
    onSurfaceVariant = ThinkivoColors.Gray700,

    outline = ThinkivoColors.Gray400,
    outlineVariant = ThinkivoColors.Gray300
)

val KivoDarkColorScheme = darkColorScheme(
    primary = ThinkivoColors.PrimaryLight,
    onPrimary = ThinkivoColors.Gray900,
    primaryContainer = ThinkivoColors.PrimaryDark,
    onPrimaryContainer = ThinkivoColors.PrimaryLightest,

    secondary = ThinkivoColors.Gray400,
    onSecondary = ThinkivoColors.Gray900,
    secondaryContainer = ThinkivoColors.Gray700,
    onSecondaryContainer = ThinkivoColors.Gray200,

    tertiary = ThinkivoColors.Layout.PurpleLight,
    onTertiary = ThinkivoColors.Gray900,
    tertiaryContainer = ThinkivoColors.Layout.Purple,
    onTertiaryContainer = ThinkivoColors.Gray100,

    error = ThinkivoColors.DangerLight,
    onError = ThinkivoColors.Gray900,
    errorContainer = ThinkivoColors.DangerDark,
    onErrorContainer = ThinkivoColors.DangerLightest,

    background = ThinkivoColors.Gray900,
    onBackground = ThinkivoColors.White,
    surface = ThinkivoColors.Gray800,
    onSurface = ThinkivoColors.White,
    surfaceVariant = ThinkivoColors.Gray700,
    onSurfaceVariant = ThinkivoColors.Gray300,

    outline = ThinkivoColors.Gray600,
    outlineVariant = ThinkivoColors.Gray700
)

// Typography
@Composable
private fun createKivoTypography(): Typography {
    return Typography(
        displayLarge = ThinkivoTypography.DisplayLarge,
        displayMedium = ThinkivoTypography.DisplayMedium,
        displaySmall = ThinkivoTypography.DisplaySmall,
        headlineLarge = ThinkivoTypography.H1,
        headlineMedium = ThinkivoTypography.H2,
        headlineSmall = ThinkivoTypography.H3,
        titleLarge = ThinkivoTypography.H4,
        titleMedium = ThinkivoTypography.H5,
        titleSmall = ThinkivoTypography.H6,
        bodyLarge = ThinkivoTypography.BodyLarge,
        bodyMedium = ThinkivoTypography.BodyMedium,
        bodySmall = ThinkivoTypography.BodySmall,
        labelLarge = ThinkivoTypography.LabelLarge,
        labelMedium = ThinkivoTypography.LabelMedium,
        labelSmall = ThinkivoTypography.LabelSmall
    )
}

// Composition Locals
private val LocalKivoColors = staticCompositionLocalOf { KivoLightColors }
private val LocalKivoTypography = staticCompositionLocalOf { ThinkivoTypography }
private val LocalKivoSpacing = staticCompositionLocalOf { KivoSpacingTokens() }

// Spacing tokens instance
private val KivoSpacingInstance = KivoSpacingTokens()
