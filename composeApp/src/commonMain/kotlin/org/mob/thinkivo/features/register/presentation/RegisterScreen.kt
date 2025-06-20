package org.mob.thinkivo.features.register.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.mob.thinkivo.kivodesign.components.button.KivoButton
import org.mob.thinkivo.kivodesign.components.button.KivoButtonSize
import org.mob.thinkivo.kivodesign.components.button.KivoButtonStyle
import org.mob.thinkivo.kivodesign.theme.KivoTheme

/**
 * Beautiful Register Screen with modern UI/UX design using KivoDesign system
 * Features:
 * - Gradient background with decorative blur elements
 * - Glass morphism card design
 * - Social login options
 * - Smooth visual effects
 * - Responsive layout
 */
@Composable
fun RegisterScreen(
    state: RegisterState,
    onEvent: (RegisterEvent) -> Unit,
    enableScrolling: Boolean = true,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(
                    brush =
                        Brush.verticalGradient(
                            colors =
                                listOf(
                                    KivoTheme.colors.primary.copy(alpha = 0.1f),
                                    KivoTheme.colors.background,
                                    KivoTheme.colors.surface,
                                ),
                        ),
                ),
    ) {
        // Background decorative elements
        BackgroundDecoration()

        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .let { if (enableScrolling) it.verticalScroll(rememberScrollState()) else it }
                    .padding(KivoTheme.spacing.l),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // Logo and Welcome Section
            WelcomeSection()

            Spacer(modifier = Modifier.height(KivoTheme.spacing.xxxl))

            // Main Register Card
            RegisterCard(
                fullName = state.fullName,
                email = state.email,
                password = state.password,
                confirmPassword = state.confirmPassword,
                isPasswordVisible = state.isPasswordVisible,
                isConfirmPasswordVisible = state.isConfirmPasswordVisible,
                onFullNameChange = { onEvent(RegisterEvent.FullNameChanged(it)) },
                onEmailChange = { onEvent(RegisterEvent.EmailChanged(it)) },
                onPasswordChange = { onEvent(RegisterEvent.PasswordChanged(it)) },
                onConfirmPasswordChange = { onEvent(RegisterEvent.ConfirmPasswordChanged(it)) },
                onPasswordVisibilityToggle = { onEvent(RegisterEvent.TogglePasswordVisibility) },
                onConfirmPasswordVisibilityToggle = { onEvent(RegisterEvent.ToggleConfirmPasswordVisibility) },
                onRegisterClick = { onEvent(RegisterEvent.Register) },
            )

            Spacer(modifier = Modifier.height(KivoTheme.spacing.xl))

            // Social Login Section
            SocialLoginSection(
                onGoogleLoginClick = { onEvent(RegisterEvent.GoogleLogin) },
            )

            Spacer(modifier = Modifier.height(KivoTheme.spacing.xl))

            // Sign In Section
            SignInSection(onLoginClick = { onEvent(RegisterEvent.Login) })

            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Composable
private fun BackgroundDecoration() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Top-right decorative circle
        Box(
            modifier =
                Modifier
                    .size(200.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = 100.dp, y = (-100).dp)
                    .background(
                        KivoTheme.colors.primary.copy(alpha = 0.1f),
                        CircleShape,
                    )
                    .blur(50.dp),
        )

        // Bottom-left decorative circle
        Box(
            modifier =
                Modifier
                    .size(150.dp)
                    .align(Alignment.BottomStart)
                    .offset(x = (-75).dp, y = 75.dp)
                    .background(
                        KivoTheme.colors.secondary.copy(alpha = 0.08f),
                        CircleShape,
                    )
                    .blur(40.dp),
        )
    }
}

@Composable
private fun WelcomeSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(KivoTheme.spacing.m),
    ) {
        // App Logo/Icon
        Box(
            modifier =
                Modifier
                    .size(80.dp)
                    .background(
                        brush =
                            Brush.linearGradient(
                                colors =
                                    listOf(
                                        KivoTheme.colors.primary,
                                        KivoTheme.colors.primary.copy(alpha = 0.8f),
                                    ),
                            ),
                        shape = RoundedCornerShape(20.dp),
                    ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "K",
                style = KivoTheme.typography.H2,
                color = KivoTheme.colors.onPrimary,
                fontWeight = FontWeight.Bold,
            )
        }

        Text(
            text = "Create an Account",
            style = KivoTheme.typography.H3,
            color = KivoTheme.colors.onSurface,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "Let's get you started on your journey",
            style = KivoTheme.typography.BodyLarge,
            color = KivoTheme.colors.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun RegisterCard(
    fullName: String,
    email: String,
    password: String,
    confirmPassword: String,
    isPasswordVisible: Boolean,
    isConfirmPasswordVisible: Boolean,
    onFullNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onPasswordVisibilityToggle: () -> Unit,
    onConfirmPasswordVisibilityToggle: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = KivoTheme.spacing.xs),
        shape = RoundedCornerShape(24.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = KivoTheme.colors.surface.copy(alpha = 0.95f),
            ),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 8.dp,
            ),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(KivoTheme.spacing.xl),
            verticalArrangement = Arrangement.spacedBy(KivoTheme.spacing.l),
        ) {
            Text(
                text = "Sign Up",
                style = KivoTheme.typography.H5,
                color = KivoTheme.colors.onSurface,
                fontWeight = FontWeight.SemiBold,
            )

            // Full Name Field
            OutlinedTextField(
                value = fullName,
                onValueChange = onFullNameChange,
                label = { Text("Full Name") },
                placeholder = { Text("Enter your full name") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Full Name",
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
            )

            // Email Field
            OutlinedTextField(
                value = email,
                onValueChange = onEmailChange,
                label = { Text("Email") },
                placeholder = { Text("Enter your email") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
            )

            // Password Field
            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text("Password") },
                placeholder = { Text("Enter your password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password",
                    )
                },
                trailingIcon = {
                    IconButton(onClick = onPasswordVisibilityToggle) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                        )
                    }
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
            )

            // Confirm Password Field
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = onConfirmPasswordChange,
                label = { Text("Confirm Password") },
                placeholder = { Text("Confirm your password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Confirm Password",
                    )
                },
                trailingIcon = {
                    IconButton(onClick = onConfirmPasswordVisibilityToggle) {
                        Icon(
                            imageVector = if (isConfirmPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = if (isConfirmPasswordVisible) "Hide password" else "Show password",
                        )
                    }
                },
                visualTransformation = if (isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
            )

            Spacer(modifier = Modifier.height(KivoTheme.spacing.m))

            // Register Button
            KivoButton(
                text = "Sign Up",
                onClick = onRegisterClick,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                size = KivoButtonSize.Large,
            )
        }
    }
}

@Composable
private fun SocialLoginSection(onGoogleLoginClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(KivoTheme.spacing.l),
    ) {
        // Divider with text
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(KivoTheme.spacing.m),
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = KivoTheme.colors.outline.copy(alpha = 0.5f),
            )
            Text(
                text = "Or continue with",
                style = KivoTheme.typography.BodySmall,
                color = KivoTheme.colors.onSurfaceVariant,
            )
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = KivoTheme.colors.outline.copy(alpha = 0.5f),
            )
        }

        // Google Login Button - Full Width
        Card(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors =
                CardDefaults.cardColors(
                    containerColor = KivoTheme.colors.surface,
                ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                KivoButton(
                    text = "Continue with Google",
                    onClick = onGoogleLoginClick,
                    style = KivoButtonStyle.Outlined,
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                    size = KivoButtonSize.Large,
                )
            }
        }
    }
}

@Composable
private fun SignInSection(onLoginClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Already have an account? ",
            style = KivoTheme.typography.BodyMedium,
            color = KivoTheme.colors.onSurfaceVariant,
        )
        TextButton(onClick = onLoginClick) {
            Text(
                text = "Sign In",
                style = KivoTheme.typography.BodyMedium,
                color = KivoTheme.colors.primary,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
} 
