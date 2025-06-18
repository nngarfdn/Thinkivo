package design.system.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * ThinkivoColors defines the color palette for the Thinkivo design system.
 * Based on KivoDesign principles with semantic color naming.
 */
@Immutable
object ThinkivoColors {
    
    // Brand Colors
    val Primary = Color(0xFF006EFF)
    val Danger = Color(0xFFF46363)
    val Success = Color(0xFF2ED477)
    val Warning = Color(0xFFFF9138)
    
    // Neutral Colors
    val Black = Color(0xFF121212)
    val Gray = Color(0xFF808080)
    val Gray200 = Color(0xFFE5E5E5)
    val Gray300 = Color(0xFFD4D4D4)
    val Gray400 = Color(0xFFA3A3A3)
    val Gray500 = Color(0xFF737373)
    val Gray600 = Color(0xFF525252)
    val Gray700 = Color(0xFF404040)
    
    // White
    val White = Color(0xFFFFFFFF)
    
    // Semantic Colors for Light Theme
    object Light {
        val Background = White
        val Surface = White
        val SurfaceVariant = Gray200
        val OnBackground = Black
        val OnSurface = Black
        val OnSurfaceVariant = Gray700
        val OnPrimary = White
        val OnDanger = White
        val OnSuccess = White
        val OnWarning = White
        val Outline = Gray400
        val OutlineVariant = Gray300
    }
    
    // Semantic Colors for Dark Theme
    object Dark {
        val Background = Color(0xFF0F0F0F)
        val Surface = Color(0xFF1A1A1A)
        val SurfaceVariant = Gray700
        val OnBackground = White
        val OnSurface = White
        val OnSurfaceVariant = Gray300
        val OnPrimary = White
        val OnDanger = White
        val OnSuccess = White
        val OnWarning = Black
        val Outline = Gray600
        val OutlineVariant = Gray700
    }
    
    // System State Colors
    object System {
        val Error = Danger
        val ErrorContainer = Color(0xFFFFEDEA)
        val OnError = White
        val OnErrorContainer = Color(0xFF410002)
        
        val Warning = Warning
        val WarningContainer = Color(0xFFFFF4E6)
        val OnWarning = White
        val OnWarningContainer = Color(0xFF2D1B00)
        
        val Success = Success
        val SuccessContainer = Color(0xFFE8F8ED)
        val OnSuccess = White
        val OnSuccessContainer = Color(0xFF002106)
        
        val Info = Primary
        val InfoContainer = Color(0xFFE1F2FF)
        val OnInfo = White
        val OnInfoContainer = Color(0xFF001D35)
    }
}