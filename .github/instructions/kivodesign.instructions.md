# KivoDesign System Instructions

## 🎨 Design Philosophy

KivoDesign is built on the principle of **simplicity, consistency, and cross-platform excellence**. Every component should work seamlessly across Android, iOS, and Desktop while maintaining native performance and feel.

## 🏗️ Architecture Principles

### 1. **Token-First Design**
- All design decisions stem from design tokens
- Tokens are platform-agnostic and theme-aware
- Easy to maintain and update across all platforms

### 2. **Compose-Native Components**
- Built with Jetpack Compose Multiplatform
- Leverage platform-specific behaviors when needed
- Consistent API across all platforms

### 3. **Theme-Driven Development**
- Support for Light/Dark themes out of the box
- Dynamic color support on supported platforms
- Accessibility-first approach

## 📋 Implementation Rules

### ✅ DO
- Use semantic color names (Primary, Surface, OnSurface)
- Implement responsive design with breakpoints
- Follow Material Design 3 guidelines as base
- Use design tokens for all spacing, colors, and typography
- Test components on all target platforms
- Provide accessibility labels and semantics
- Use consistent naming conventions

### ❌ DON'T
- Hardcode colors or dimensions
- Use platform-specific code in common components
- Break consistency for minor customizations
- Ignore accessibility requirements
- Use magic numbers in spacing

## 🎯 Component Standards

### **Naming Convention**
```kotlin
// Components: KivoXxxxx
KivoButton, KivoCard, KivoTextField

// Theme objects: KivoTheme
KivoTheme.colors, KivoTheme.typography, KivoTheme.spacing

// Design tokens: Kivo prefix
KivoColors, KivoSpacing, KivoTypography
```

### **Component Structure**
```kotlin
@Composable
fun KivoComponent(
    // Required parameters first
    text: String,
    // Optional parameters with defaults
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    // Style parameters last
    colors: ComponentColors = KivoComponentDefaults.colors(),
    // Event handlers last
    onClick: () -> Unit = {}
) {
    // Implementation
}
```

## 🚀 Usage Guidelines

### **Quick Start**
```kotlin
// 1. Wrap your app with KivoTheme
KivoTheme {
    // Your app content
}

// 2. Use components with semantic meaning
KivoButton(
    text = "Primary Action",
    style = KivoButtonStyle.Primary
)

// 3. Access theme tokens directly
Text(
    text = "Content",
    color = KivoTheme.colors.onSurface,
    style = KivoTheme.typography.bodyLarge
)
```

## 📐 Design Token Structure

Based on the provided screenshots, our design system includes:

### **Colors**
- **Brand Colors**: Primary (#006EFF), Danger (#F46363), Success (#2ED477), Warning (#FF9138)
- **Neutral Colors**: Black (#121212), Gray variants (200-700)
- **Semantic Colors**: Background, Surface, OnSurface, etc.
- **System Colors**: Error, Warning, Success states

### **Typography**
- **Font Family**: SF Pro Display (iOS), Roboto (Android), System (Desktop)
- **Weights**: Heavy, Bold, Medium, Regular, Thin
- **Scales**: H1-H6, Body, Caption, Small, Tiny
- **Responsive sizing**: Adapts to platform conventions

### **Spacing**
- **Scale**: 4dp base unit (4, 8, 12, 16, 20, 24, 32, 40, 48, 64)
- **Semantic names**: XS, S, M, L, XL, XXL
- **Component-specific**: Button padding, card margins, etc.

### **Elevation**
- **4 Levels**: 0dp, 2dp, 4dp, 8dp
- **Contextual usage**: Cards, dialogs, app bars
- **Platform adaptation**: Material shadows, iOS blur effects

## 🔧 Development Workflow

### **Adding New Components**
1. Define design tokens first
2. Create component in commonMain
3. Add platform-specific implementations if needed
4. Write comprehensive tests
5. Document usage examples
6. Update design system docs

### **Updating Tokens**
1. Update tokens in design system
2. Test across all platforms
3. Update documentation
4. Run visual regression tests
5. Communicate changes to team

## 📚 File Organization

```
kivodesign/
├── tokens/
│   ├── KivoColors.kt
│   ├── KivoTypography.kt
│   ├── KivoSpacing.kt
│   └── KivoElevation.kt
├── theme/
│   ├── KivoTheme.kt
│   ├── LightColorScheme.kt
│   └── DarkColorScheme.kt
├── components/
│   ├── button/
│   ├── card/
│   ├── textfield/
│   └── ...
└── foundations/
    ├── Layout.kt
    ├── Motion.kt
    └── Accessibility.kt
```

## 🎨 Visual Guidelines

### **Color Usage**
- Primary: Main brand actions, active states
- Danger: Destructive actions, errors
- Success: Confirmations, positive feedback
- Warning: Cautions, important notices
- Neutral: Text, borders, backgrounds

### **Typography Hierarchy**
- H1: Page titles, hero content
- H2-H3: Section headers
- H4-H6: Subsection headers
- Body: Main content text
- Caption: Secondary information
- Small/Tiny: Labels, metadata

### **Spacing Consistency**
- Use spacing tokens consistently
- Maintain visual rhythm
- Consider touch targets (44dp minimum)
- Respect platform conventions

## 🧪 Testing Strategy

### **Visual Testing**
- Screenshot tests for all components
- Theme switching tests
- Platform-specific rendering tests

### **Accessibility Testing**
- Screen reader compatibility
- Color contrast validation
- Touch target size verification

### **Cross-Platform Testing**
- Component behavior consistency
- Performance benchmarks
- Platform-specific feature tests

## 🚀 Performance Guidelines

### **Optimization Rules**
- Use remember() for expensive calculations
- Implement proper key strategies for lists
- Avoid unnecessary recompositions
- Profile performance on target devices

### **Bundle Size**
- Tree-shake unused components
- Optimize asset sizes
- Use vector graphics when possible

## 📖 Documentation Standards

### **Component Documentation**
```kotlin
/**
 * KivoButton provides consistent button styling across platforms.
 * 
 * @param text The button text to display
 * @param onClick Callback when button is pressed
 * @param modifier Modifier to be applied to the button
 * @param enabled Whether the button is enabled
 * @param style Visual style of the button
 * 
 * @sample KivoButtonSample
 */
```

### **Design Token Documentation**
- Include usage examples
- Show visual comparisons
- Explain semantic meaning
- Provide migration guides

## 🔄 Versioning Strategy

### **Version Format**: Major.Minor.Patch
- **Major**: Breaking changes, new design language
- **Minor**: New components, token additions
- **Patch**: Bug fixes, minor improvements

### **Changelog Requirements**
- Breaking changes clearly marked
- Migration guides for major updates
- Visual examples for new components

## 🎯 Success Metrics

### **Developer Experience**
- Time to implement new screens
- Design-dev handoff efficiency
- Code review feedback quality

### **User Experience**
- Cross-platform consistency scores
- Accessibility compliance rates
- Performance benchmarks

### **Maintenance**
- Design token coverage
- Component reusability rates
- Bug report frequency

---

*This document serves as the foundation for KivoDesign implementation. All team members should familiarize themselves with these guidelines before contributing to the design system.*