# KivoTextField Component

A comprehensive text field component system for KivoDesign that provides consistent styling across Android, iOS, and Desktop platforms.

## Features

- ✅ **Multiple states** - Default, focused, disabled, error states
- ✅ **Icon support** - Leading and trailing icons with interaction
- ✅ **Validation** - Built-in error state with supporting text
- ✅ **Accessibility** - Proper semantics and screen reader support
- ✅ **Theme-aware** - Automatically adapts to light/dark themes
- ✅ **Cross-platform** - Works on Android, iOS, Desktop
- ✅ **Customizable** - Colors, typography, and behavior

## Components

### KivoTextField
Main text field component with full customization options.

```kotlin
KivoTextField(
    value = text,
    onValueChange = { text = it },
    placeholder = "Enter text...",
    label = "Text Field",
    leadingIcon = Icons.Default.Search,
    trailingIcon = Icons.Default.Clear,
    onTrailingIconClick = { text = "" },
    isError = false,
    supportingText = "Helper text"
)
```

## States

### Default States
- **Normal** - Default unfocused state
- **Focused** - Active state with primary color border
- **Disabled** - Non-interactive state with reduced opacity
- **Error** - Invalid state with error color and supporting text

### Icon Configurations
- **No Icon** - Clean text field without icons
- **Leading Icon** - Icon at the start of the text field
- **Trailing Icon** - Icon at the end of the text field
- **Both Icons** - Icons on both sides

## Usage Examples

### Basic Text Field
```kotlin
var text by remember { mutableStateOf("") }

KivoTextField(
    value = text,
    onValueChange = { text = it },
    placeholder = "Enter text..."
)
```

### Search Field
```kotlin
var searchQuery by remember { mutableStateOf("") }

KivoTextField(
    value = searchQuery,
    onValueChange = { searchQuery = it },
    placeholder = "Search...",
    leadingIcon = Icons.Default.Search,
    trailingIcon = if (searchQuery.isNotEmpty()) Icons.Default.Clear else null,
    onTrailingIconClick = if (searchQuery.isNotEmpty()) {
        { searchQuery = "" }
    } else null
)
```

### Password Field
```kotlin
var password by remember { mutableStateOf("") }
var passwordVisible by remember { mutableStateOf(false) }

KivoTextField(
    value = password,
    onValueChange = { password = it },
    placeholder = "Enter password",
    label = "Password",
    trailingIcon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
    onTrailingIconClick = { passwordVisible = !passwordVisible },
    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
)
```

### Validation Field
```kotlin
var email by remember { mutableStateOf("") }
val isValidEmail = email.contains("@") && email.contains(".")

KivoTextField(
    value = email,
    onValueChange = { email = it },
    placeholder = "Enter email",
    label = "Email Address",
    isError = email.isNotEmpty() && !isValidEmail,
    supportingText = when {
        email.isEmpty() -> "Required field"
        !isValidEmail -> "Please enter a valid email address"
        else -> "Looks good!"
    }
)
```

### Dropdown Field
```kotlin
var selectedValue by remember { mutableStateOf("") }

KivoTextField(
    value = selectedValue,
    onValueChange = { /* Read-only for dropdown */ },
    placeholder = "Select option",
    label = "Dropdown",
    readOnly = true,
    trailingIcon = Icons.Default.ArrowDropDown,
    onTrailingIconClick = { /* Open dropdown */ }
)
```

## Color Customization

```kotlin
KivoTextField(
    value = text,
    onValueChange = { text = it },
    colors = KivoTextFieldDefaults.colors(
        focusedBorderColor = CustomColors.Brand,
        errorColor = CustomColors.Error,
        textColor = CustomColors.Text
    )
)
```

## Parameters

### Core Parameters
- `value: String` - Current text value
- `onValueChange: (String) -> Unit` - Text change callback
- `modifier: Modifier` - Compose modifier
- `enabled: Boolean` - Whether field is interactive
- `readOnly: Boolean` - Whether field is read-only

### Content Parameters
- `placeholder: String?` - Placeholder text
- `label: String?` - Optional label above field
- `supportingText: String?` - Helper/error text below field

### Icon Parameters
- `leadingIcon: ImageVector?` - Icon at start
- `trailingIcon: ImageVector?` - Icon at end
- `onTrailingIconClick: (() -> Unit)?` - Trailing icon tap handler

### State Parameters
- `isError: Boolean` - Error state flag
- `visualTransformation: VisualTransformation` - Text transformation (e.g., password)

### Input Parameters
- `keyboardOptions: KeyboardOptions` - Keyboard configuration
- `keyboardActions: KeyboardActions` - IME actions
- `singleLine: Boolean` - Single vs multi-line
- `maxLines: Int` - Maximum lines for multi-line
- `minLines: Int` - Minimum lines for multi-line

### Styling Parameters
- `colors: KivoTextFieldColors` - Color configuration
- `interactionSource: MutableInteractionSource` - Interaction handling

## Demo

Use `KivoTextFieldDemo()` to see all variants:

```kotlin
@Composable
fun MyApp() {
    KivoTheme {
        KivoTextFieldDemo()
    }
}
```

## Architecture

The text field system follows KivoDesign principles:

- **Token-first**: All styling comes from design tokens
- **Semantic colors**: Error, focus, and disabled states use semantic colors
- **Cross-platform**: Uses Compose Multiplatform for consistency
- **Accessibility**: Proper content descriptions and semantics
- **Theme-aware**: Supports light/dark themes automatically

## Design States

Based on the design system image, the component supports:

### Contained Style
- Outlined border design
- Consistent corner radius (8dp)
- Proper spacing and typography
- State-aware colors

### Visual States
1. **Default** - Gray outline, placeholder text
2. **Focused** - Blue outline, cursor visible
3. **Disabled** - Reduced opacity, no interaction
4. **Error** - Red outline, error icon, supporting text

### Icon Positions
1. **No Icon** - Clean minimal design
2. **Trailing Icon** - Right-side icon (dropdown, clear, etc.)
3. **Leading Icon** - Left-side icon (search, category, etc.)

## Integration

1. Import the text field components:
```kotlin
import org.mob.thinkivo.kivodesign.components.textfield.KivoTextField
import org.mob.thinkivo.kivodesign.components.textfield.KivoTextFieldDefaults
```

2. Wrap your app with KivoTheme:
```kotlin
KivoTheme {
    // Your app content with KivoTextFields
}
```

3. Use text fields consistently throughout your app following the design system guidelines.

---

*Part of the KivoDesign System - Built for cross-platform excellence*
