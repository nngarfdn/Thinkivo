# KivoDesign Theme System

A comprehensive theme system for KivoDesign that provides automatic light/dark mode support with seamless transitions and complete component adaptation.

## 🌟 Features

- ✅ **Automatic theme switching** - Light/Dark mode toggle
- ✅ **Complete component adaptation** - All components automatically adapt
- ✅ **Semantic color system** - Follows Material Design 3 principles
- ✅ **Typography integration** - Custom typography tokens
- ✅ **Spacing tokens** - Consistent spacing system
- ✅ **Cross-platform** - Works on Android, iOS, Desktop
- ✅ **Theme persistence** - Centralized theme state management

## 🏗️ Architecture

### KivoTheme
The main theme provider that wraps your entire app:

```kotlin
@Composable
fun App() {
    KivoTheme(darkTheme = ThemeManager.isDarkTheme) {
        // Your app content
    }
}
```

### ThemeManager
Centralized theme state management:

```kotlin
object ThemeManager {
    var isDarkTheme: Boolean // Current theme state
    fun toggleTheme() // Toggle between themes
    fun setTheme(darkTheme: Boolean) // Set specific theme
}
```

### KivoThemeToggle
Ready-to-use theme toggle component:

```kotlin
KivoThemeToggle(
    isDarkTheme = ThemeManager.isDarkTheme,
    onThemeChange = { ThemeManager.setTheme(it) },
    showLabel = true
)
```

## 🎨 Theme Colors

### Light Theme
- **Primary**: #1E88E5 (Blue)
- **Background**: #FFFFFF (White)
- **Surface**: #FFFFFF (White)
- **On Surface**: #212121 (Dark Gray)

### Dark Theme
- **Primary**: #64B5F6 (Light Blue)
- **Background**: #212121 (Dark Gray)
- **Surface**: #424242 (Medium Gray)
- **On Surface**: #FFFFFF (White)

### Semantic Colors
Both themes include:
- Success (Green variants)
- Warning (Orange variants)
- Error/Danger (Red variants)
- Secondary (Gray variants)

## 📖 Usage Examples

### Basic Setup
```kotlin
@Composable
fun MyApp() {
    KivoTheme {
        // Your content automatically gets themed
        Text(
            text = "Hello World",
            color = KivoTheme.colors.onSurface
        )
    }
}
```

### Accessing Theme Tokens
```kotlin
@Composable
fun MyComponent() {
    Column(
        modifier = Modifier.padding(KivoTheme.spacing.m)
    ) {
        Text(
            text = "Title",
            style = KivoTheme.typography.H4,
            color = KivoTheme.colors.primary
        )
        
        Text(
            text = "Description",
            style = KivoTheme.typography.BodyMedium,
            color = KivoTheme.colors.onSurfaceVariant
        )
    }
}
```

### Theme-Aware Components
```kotlin
@Composable
fun ThemedCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = KivoTheme.colors.surface,
            contentColor = KivoTheme.colors.onSurface
        )
    ) {
        // Content automatically adapts to theme
    }
}
```

### Manual Theme Control
```kotlin
@Composable
fun SettingsScreen() {
    Column {
        Text("Theme Settings")
        
        Row {
            Text("Dark Mode")
            Switch(
                checked = ThemeManager.isDarkTheme,
                onCheckedChange = { ThemeManager.setTheme(it) }
            )
        }
        
        // Or use the built-in toggle
        KivoThemeToggle(
            isDarkTheme = ThemeManager.isDarkTheme,
            onThemeChange = { ThemeManager.setTheme(it) }
        )
    }
}
```

## 🎯 Color System

### Accessing Colors
```kotlin
// Primary colors
KivoTheme.colors.primary
KivoTheme.colors.onPrimary
KivoTheme.colors.primaryContainer

// Surface colors
KivoTheme.colors.surface
KivoTheme.colors.onSurface
KivoTheme.colors.surfaceVariant

// Semantic colors
KivoTheme.colors.success
KivoTheme.colors.warning
KivoTheme.colors.error

// Background colors
KivoTheme.colors.background
KivoTheme.colors.onBackground
```

### Custom Color Usage
```kotlin
@Composable
fun CustomComponent() {
    Box(
        modifier = Modifier
            .background(KivoTheme.colors.primaryContainer)
            .border(1.dp, KivoTheme.colors.outline)
    ) {
        Text(
            text = "Custom",
            color = KivoTheme.colors.onPrimaryContainer
        )
    }
}
```

## 📝 Typography Integration

```kotlin
// Heading styles
KivoTheme.typography.H1
KivoTheme.typography.H2
KivoTheme.typography.H3
KivoTheme.typography.H4
KivoTheme.typography.H5
KivoTheme.typography.H6

// Body text
KivoTheme.typography.BodyLarge
KivoTheme.typography.BodyMedium
KivoTheme.typography.BodySmall

// Labels and captions
KivoTheme.typography.LabelLarge
KivoTheme.typography.LabelMedium
KivoTheme.typography.Caption
```

## 📏 Spacing System

```kotlin
// Spacing tokens
KivoTheme.spacing.xs    // 4dp
KivoTheme.spacing.s     // 8dp  
KivoTheme.spacing.m     // 12dp
KivoTheme.spacing.l     // 16dp
KivoTheme.spacing.xl    // 20dp
KivoTheme.spacing.xxl   // 24dp
KivoTheme.spacing.xxxl  // 32dp
```

## 🚀 Advanced Usage

### System Theme Detection
```kotlin
@Composable
fun App() {
    // Automatically follows system theme
    KivoTheme(darkTheme = isSystemInDarkTheme()) {
        MyContent()
    }
}
```

### Theme Persistence (Future Enhancement)
```kotlin
// Could be extended to persist theme preference
object ThemeManager {
    var isDarkTheme by remember { 
        mutableStateOf(getStoredThemePreference()) 
    }
    
    fun setTheme(darkTheme: Boolean) {
        isDarkTheme = darkTheme
        saveThemePreference(darkTheme)
    }
}
```

### Custom Theme Colors
```kotlin
// Extend the theme with custom colors
val CustomKivoColors = KivoColors(
    primary = MyBrandColors.Primary,
    // ... other colors
)

@Composable
fun CustomThemedApp() {
    CompositionLocalProvider(LocalKivoColors provides CustomKivoColors) {
        KivoTheme {
            MyContent()
        }
    }
}
```

## 🎨 Component Integration

All KivoDesign components automatically work with the theme system:

- **KivoButton** - Adapts colors and styles
- **KivoTextField** - Theme-aware colors
- **KivoCard** - Surface and content colors
- **KivoDialog** - Background and text adaptation
- **All future components** - Built-in theme support

## 📱 Platform Considerations

### Android
- Follows Material Design 3 guidelines
- Supports dynamic color (Android 12+)
- Proper status bar adaptation

### iOS
- Adapts to iOS design patterns
- Supports iOS dark/light mode
- Native feel maintained

### Desktop
- System theme detection
- Proper window chrome adaptation
- OS-specific behaviors

## 🔧 Troubleshooting

### Common Issues

1. **Theme not updating**: Ensure you're using `ThemeManager.setTheme()` 
2. **Colors not adapting**: Make sure components use `KivoTheme.colors.*`
3. **Typography not applying**: Use `KivoTheme.typography.*` styles

### Best Practices

1. Always access colors through `KivoTheme.colors.*`
2. Use semantic color names (primary, surface, etc.)
3. Test both light and dark themes
4. Ensure sufficient color contrast
5. Use the spacing tokens consistently

---

*Part of the KivoDesign System - Built for cross-platform excellence with automatic theme adaptation*
