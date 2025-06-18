package org.mob.thinkivo.kivodesign.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * ThinkivoTypography defines the typography scale for the Thinkivo design system.
 * Based on KivoDesign principles with SF Pro Display font family and semantic text styles.
 */
@Immutable
object ThinkivoTypography {
    
    // Font Weights based on design system
    object Weights {
        val Heavy = FontWeight.W900
        val Bold = FontWeight.W700
        val Medium = FontWeight.W500
        val Regular = FontWeight.W400
        val Thin = FontWeight.W100
    }
    
    // Heading Styles
    val H1 = TextStyle(
        fontFamily = FontFamily.Default, // Will be SF Pro Display on iOS, Roboto on Android
        fontSize = 60.sp,
        fontWeight = Weights.Heavy,
        lineHeight = 68.sp,
        letterSpacing = (-0.5).sp
    )
    
    val H2 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 48.sp,
        fontWeight = Weights.Bold,
        lineHeight = 56.sp,
        letterSpacing = (-0.4).sp
    )
    
    val H3 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 40.sp,
        fontWeight = Weights.Bold,
        lineHeight = 48.sp,
        letterSpacing = (-0.3).sp
    )
    
    val H4 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 32.sp,
        fontWeight = Weights.Medium,
        lineHeight = 40.sp,
        letterSpacing = (-0.2).sp
    )
    
    val H5 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 24.sp,
        fontWeight = Weights.Medium,
        lineHeight = 32.sp,
        letterSpacing = (-0.1).sp
    )
    
    val H6 = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 20.sp,
        fontWeight = Weights.Medium,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )
    
    // Body Text Styles
    val BodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 18.sp,
        fontWeight = Weights.Regular,
        lineHeight = 26.sp,
        letterSpacing = 0.1.sp
    )
    
    val BodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        fontWeight = Weights.Regular,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    )
    
    val BodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp,
        fontWeight = Weights.Regular,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
    
    // Supporting Text Styles
    val Caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 12.sp,
        fontWeight = Weights.Regular,
        lineHeight = 16.sp,
        letterSpacing = 0.2.sp
    )
    
    val Small = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 10.sp,
        fontWeight = Weights.Regular,
        lineHeight = 14.sp,
        letterSpacing = 0.2.sp
    )
    
    val Tiny = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 8.sp,
        fontWeight = Weights.Regular,
        lineHeight = 12.sp,
        letterSpacing = 0.3.sp
    )
    
    // Label Styles (for buttons, form labels, etc.)
    val LabelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        fontWeight = Weights.Medium,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
    
    val LabelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 14.sp,
        fontWeight = Weights.Medium,
        lineHeight = 18.sp,
        letterSpacing = 0.1.sp
    )
    
    val LabelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 12.sp,
        fontWeight = Weights.Medium,
        lineHeight = 16.sp,
        letterSpacing = 0.2.sp
    )
    
    // Display Styles (for hero text, marketing content)
    val DisplayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 96.sp,
        fontWeight = Weights.Heavy,
        lineHeight = 104.sp,
        letterSpacing = (-1.5).sp
    )
    
    val DisplayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 72.sp,
        fontWeight = Weights.Heavy,
        lineHeight = 80.sp,
        letterSpacing = (-1.0).sp
    )
    
    val DisplaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 64.sp,
        fontWeight = Weights.Heavy,
        lineHeight = 72.sp,
        letterSpacing = (-0.8).sp
    )
}