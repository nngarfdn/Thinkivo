# KivoButton Component

A comprehensive button component system for KivoDesign that provides consistent styling across Android, iOS, and Desktop platforms.

## Features

- ✅ **Fill & Outline variants** - Matches your design system exactly
- ✅ **Multiple sizes** - ExtraLarge, Large, Medium, Small + Icon variants
- ✅ **Icon support** - Icon-only, text+icon with leading/trailing positions
- ✅ **Color variants** - Primary, Danger, Success, Warning, Secondary
- ✅ **Disabled states** - Proper visual feedback
- ✅ **Cross-platform** - Works on Android, iOS, Desktop
- ✅ **Accessibility** - Screen reader support and proper touch targets

## Components

### KivoButton
Basic text button with customizable styling.

```kotlin
KivoButton(
    text = "Button",
    onClick = { /* handle click */ },
    style = KivoButtonStyle.Filled, // or Outlined
    size = KivoButtonSize.Large,
    colors = KivoButtonDefaults.colors()
)
```

### KivoIconButton
Icon-only button for compact UIs.

```kotlin
KivoIconButton(
    icon = Icons.Default.Favorite,
    contentDescription = "Favorite",
    onClick = { /* handle click */ },
    style = KivoButtonStyle.Filled,
    size = KivoButtonSize.IconLarge
)
```

### KivoTextIconButton
Button with both text and icon support.

```kotlin
KivoTextIconButton(
    text = "Button",
    icon = Icons.Default.Favorite,
    contentDescription = "Favorite",
    onClick = { /* handle click */ },
    iconPosition = KivoIconPosition.Leading, // or Trailing
    style = KivoButtonStyle.Filled,
    size = KivoButtonSize.Large
)
```

## Button Styles

### KivoButtonStyle
- `Filled` - Solid background button (default)
- `Outlined` - Transparent background with border

## Button Sizes

### Text Buttons
- `ExtraLarge` - 56dp height, 24dp horizontal padding
- `Large` - 48dp height, 20dp horizontal padding  
- `Medium` - 40dp height, 16dp horizontal padding
- `Small` - 32dp height, 12dp horizontal padding

### Icon Buttons
- `IconLarge` - 48x48dp
- `IconMedium` - 40x40dp
- `IconSmall` - 32x32dp

## Color Variants

Use `KivoButtonDefaults` to get predefined color schemes:

```kotlin
// Primary (default)
KivoButtonDefaults.colors()

// Danger/Error actions
KivoButtonDefaults.dangerColors()

// Success actions  
KivoButtonDefaults.successColors()

// Warning actions
KivoButtonDefaults.warningColors()

// Secondary/Neutral actions
KivoButtonDefaults.secondaryColors()
```

## Custom Colors

```kotlin
KivoButton(
    text = "Custom",
    onClick = { },
    colors = KivoButtonColors(
        containerColor = ThinkivoColors.Layout.Purple,
        contentColor = ThinkivoColors.White,
        disabledContainerColor = ThinkivoColors.Gray300,
        disabledContentColor = ThinkivoColors.Gray500
    )
)
```

## Usage Examples

### Basic Buttons
```kotlin
// Filled primary button
KivoButton(
    text = "Primary Action",
    onClick = { }
)

// Outlined secondary button
KivoButton(
    text = "Secondary Action", 
    onClick = { },
    style = KivoButtonStyle.Outlined
)
```

### Icon Buttons
```kotlin
// Icon only button
KivoIconButton(
    icon = Icons.Default.Add,
    contentDescription = "Add item",
    onClick = { }
)

// Text with leading icon
KivoTextIconButton(
    text = "Save",
    icon = Icons.Default.Check,
    contentDescription = "Save",
    onClick = { }
)

// Text with trailing icon
KivoTextIconButton(
    text = "Next",
    icon = Icons.Default.ArrowForward,
    contentDescription = "Next",
    onClick = { },
    iconPosition = KivoIconPosition.Trailing
)
```

### Different Sizes
```kotlin
// Large button for primary actions
KivoButton(
    text = "Get Started",
    onClick = { },
    size = KivoButtonSize.ExtraLarge
)

// Small button for compact UIs
KivoButton(
    text = "Cancel",
    onClick = { },
    size = KivoButtonSize.Small,
    style = KivoButtonStyle.Outlined
)
```

### Color Variants
```kotlin
// Danger button for destructive actions
KivoButton(
    text = "Delete",
    onClick = { },
    colors = KivoButtonDefaults.dangerColors()
)

// Success button for positive actions
KivoButton(
    text = "Confirm",
    onClick = { },
    colors = KivoButtonDefaults.successColors()
)
```

### Disabled State
```kotlin
KivoButton(
    text = "Disabled",
    onClick = { },
    enabled = false
)
```

## Demo

Use `KivoButtonDemo()` composable to see all button variants in action:

```kotlin
@Composable
fun MyApp() {
    KivoTheme {
        KivoButtonDemo()
    }
}
```

## Architecture

The button system follows KivoDesign principles:

- **Token-first**: All styling comes from `ThinkivoColors` design tokens
- **Semantic naming**: Colors are named by purpose (Primary, Danger, Success)
- **Cross-platform**: Uses Compose Multiplatform for consistency
- **Accessibility**: Proper content descriptions and touch targets
- **Theme-aware**: Supports light/dark themes automatically

## Integration

1. Import the button components:
```kotlin
import org.mob.thinkivo.kivodesign.components.button.KivoButton
import org.mob.thinkivo.kivodesign.components.button.KivoButtonDefaults
import org.mob.thinkivo.kivodesign.components.button.KivoButtonStyle
import org.mob.thinkivo.kivodesign.components.button.KivoButtonSize
```

2. Wrap your app with KivoTheme:
```kotlin
KivoTheme {
    // Your app content with KivoButtons
}
```

3. Use buttons consistently throughout your app following the design system guidelines.

---

*Part of the KivoDesign System - Built for cross-platform excellence*
