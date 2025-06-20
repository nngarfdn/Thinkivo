package org.mob.thinkivo.kivodesign.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * ThinkivoColors defines the color palette for the Thinkivo design system.
 * Based on KivoDesign principles with semantic color naming.
 */
@Immutable
object ThinkivoColors {
    // Brand Colors - Primary Scale
    val Primary = Color(0xFF1E88E5) // Base Primary
    val PrimaryDark = Color(0xFF1565C0)
    val PrimaryLight = Color(0xFF64B5F6)
    val PrimaryLighter = Color(0xFF90CAF9)
    val PrimaryLightest = Color(0xFFBBDEFB)

    // Brand Colors - Danger/Error Scale
    val Danger = Color(0xFFD32F2F) // Base Danger
    val DangerDark = Color(0xFFC62828)
    val DangerLight = Color(0xFFEF5350)
    val DangerLighter = Color(0xFFE57373)
    val DangerLightest = Color(0xFFFFCDD2)

    // Brand Colors - Success Scale
    val Success = Color(0xFF388E3C) // Base Success
    val SuccessDark = Color(0xFF2E7D32)
    val SuccessLight = Color(0xFF66BB6A)
    val SuccessLighter = Color(0xFF81C784)
    val SuccessLightest = Color(0xFFC8E6C9)

    // Brand Colors - Warning Scale
    val Warning = Color(0xFFFF9800) // Base Warning
    val WarningDark = Color(0xFFEF6C00)
    val WarningLight = Color(0xFFFFB74D)
    val WarningLighter = Color(0xFFFFCC80)
    val WarningLightest = Color(0xFFFFE0B2)

    // Neutral Colors - Black to White Scale
    val Black = Color(0xFF000000)
    val Gray900 = Color(0xFF212121)
    val Gray800 = Color(0xFF424242)
    val Gray700 = Color(0xFF616161)
    val Gray600 = Color(0xFF757575)
    val Gray500 = Color(0xFF9E9E9E)
    val Gray400 = Color(0xFFBDBDBD)
    val Gray300 = Color(0xFFE0E0E0)
    val Gray200 = Color(0xFFEEEEEE)
    val Gray100 = Color(0xFFF5F5F5)
    val Gray50 = Color(0xFFFAFAFA)
    val White = Color(0xFFFFFFFF)

    // Layout Colors
    object Layout {
        val Coral = Color(0xFFFF7043)
        val CoralLight = Color(0xFFFFAB91)
        val Pink = Color(0xFFE91E63)
        val PinkLight = Color(0xFFF8BBD9)
        val Cyan = Color(0xFF00BCD4)
        val CyanLight = Color(0xFF80DEEA)
        val Green = Color(0xFF4CAF50)
        val GreenSecondary = Color(0xFF66BB6A)
        val Purple = Color(0xFF673AB7)
        val PurpleLight = Color(0xFF9575CD)
        val Orange = Color(0xFFFF5722)
        val OrangeSecondary = Color(0xFFFF8A65)
        val Blue = Color(0xFF2196F3)
        val BlueSecondary = Color(0xFF42A5F5)
        val Navy = Color(0xFF3F51B5)
        val NavySecondary = Color(0xFF5C6BC0)
        val Teal = Color(0xFF009688)
        val TealLight = Color(0xFF4DB6AC)
        val Red = Color(0xFFF44336)
        val RedLight = Color(0xFFE57373)
        val Yellow = Color(0xFFFFC107)
        val YellowLight = Color(0xFFFFD54F)
        val BlueDeep = Color(0xFF1976D2)
        val BrownDark = Color(0xFF5D4037)
        val LimeGreen = Color(0xFF8BC34A)
    }

    // Payment Colors
    object Payment {
        val Orange = Color(0xFFFF5722)
        val Blue = Color(0xFF1976D2)
        val Purple = Color(0xFF673AB7)
        val Navy = Color(0xFF283593)
    }

    // System Warning Extended
    object SystemWarning {
        val Warning1 = Color(0xFFBF6000)
        val Warning2 = Color(0xFFEF6C00)
        val Warning3 = Color(0xFFFF9800) // Base warning
        val Warning4 = Color(0xFFFFB74D)
        val Warning5 = Color(0xFFFFCC80)
        val Warning6 = Color(0xFFFFE0B2)
    }

    // Gradients
    object Gradient {
        // Gradient Bottom (from design system)
        val BlackToGray = listOf(Color(0xFF000000), Color(0xFF757575))
        val BlueGradient = listOf(Color(0xFF1976D2), Color(0xFF64B5F6))
        val PinkGradient = listOf(Color(0xFFE91E63), Color(0xFFF8BBD9))
        val OrangeGradient = listOf(Color(0xFFFF9800), Color(0xFFFFCC80))
        val GreenGradient = listOf(Color(0xFF4CAF50), Color(0xFF81C784))

        // Gradient Full (complex gradients)
        val GrayFull = listOf(Color(0xFF424242), Color(0xFF9E9E9E))
        val BlueFull = listOf(Color(0xFF1565C0), Color(0xFF90CAF9))
        val RedFull = listOf(Color(0xFFD32F2F), Color(0xFFFFCDD2))
        val OrangeFull = listOf(Color(0xFFEF6C00), Color(0xFFFFE0B2))
        val GreenFull = listOf(Color(0xFF2E7D32), Color(0xFFC8E6C9))
        val BlueToRed = listOf(Color(0xFF2196F3), Color(0xFFF44336))
        val BlueToOrange = listOf(Color(0xFF1976D2), Color(0xFFFF9800))
        val BlueToCyan = listOf(Color(0xFF2196F3), Color(0xFF00BCD4))
    }

    // Semantic Colors for Light Theme
    object Light {
        val Background = White
        val Surface = White
        val SurfaceVariant = Gray200
        val OnBackground = Gray900
        val OnSurface = Gray900
        val OnSurfaceVariant = Gray700
        val OnPrimary = White
        val OnDanger = White
        val OnSuccess = White
        val OnWarning = Gray900
        val Outline = Gray400
        val OutlineVariant = Gray300
    }

    // Semantic Colors for Dark Theme
    object Dark {
        val Background = Gray900
        val Surface = Gray800
        val SurfaceVariant = Gray700
        val OnBackground = White
        val OnSurface = White
        val OnSurfaceVariant = Gray300
        val OnPrimary = White
        val OnDanger = White
        val OnSuccess = White
        val OnWarning = Gray900
        val Outline = Gray600
        val OutlineVariant = Gray700
    }

    // System State Colors
    object System {
        val Error = Danger
        val ErrorContainer = DangerLightest
        val OnError = White
        val OnErrorContainer = DangerDark

        val Warning = ThinkivoColors.Warning
        val WarningContainer = WarningLightest
        val OnWarning = White
        val OnWarningContainer = WarningDark

        val Success = ThinkivoColors.Success
        val SuccessContainer = SuccessLightest
        val OnSuccess = White
        val OnSuccessContainer = SuccessDark

        val Info = Primary
        val InfoContainer = PrimaryLightest
        val OnInfo = White
        val OnInfoContainer = PrimaryDark
    }
}
