package org.mob.thinkivo.features.login.presentation

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
 * Beautiful Login Screen with modern UI/UX design using KivoDesign system
 * Features:
 * - Gradient background with decorative blur elements
 * - Glass morphism card design
 * - Social login options
 * - Smooth visual effects
 * - Responsive layout
 */
@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit,
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

            // Main Login Card
            LoginCard(
                email = state.email,
                password = state.password,
                isPasswordVisible = state.isPasswordVisible,
                onEmailChange = { onEvent(LoginEvent.EmailChanged(it)) },
                onPasswordChange = { onEvent(LoginEvent.PasswordChanged(it)) },
                onPasswordVisibilityToggle = { onEvent(LoginEvent.TogglePasswordVisibility) },
                onLoginClick = { onEvent(LoginEvent.Login) },
                onForgotPasswordClick = { onEvent(LoginEvent.ForgotPassword) },
            )

            Spacer(modifier = Modifier.height(KivoTheme.spacing.xl))

            // Social Login Section
            SocialLoginSection(
                onGoogleLoginClick = { onEvent(LoginEvent.GoogleLogin) },
            )

            Spacer(modifier = Modifier.height(KivoTheme.spacing.xl))

            // Sign Up Section
            SignUpSection(onSignUpClick = { onEvent(LoginEvent.SignUp) })

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
            text = "Welcome Back!",
            style = KivoTheme.typography.H3,
            color = KivoTheme.colors.onSurface,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "Sign in to continue your journey",
            style = KivoTheme.typography.BodyLarge,
            color = KivoTheme.colors.onSurfaceVariant,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun LoginCard(
    email: String,
    password: String,
    isPasswordVisible: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordVisibilityToggle: () -> Unit,
    onLoginClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
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
                text = "Sign In",
                style = KivoTheme.typography.H5,
                color = KivoTheme.colors.onSurface,
                fontWeight = FontWeight.SemiBold,
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

            // Forgot Password
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                TextButton(onClick = onForgotPasswordClick) {
                    Text(
                        text = "Forgot Password?",
                        style = KivoTheme.typography.BodyMedium,
                        color = KivoTheme.colors.primary,
                    )
                }
            }

            // Login Button
            KivoButton(
                text = "Sign In",
                onClick = onLoginClick,
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
private fun SignUpSection(onSignUpClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Don't have an account? ",
            style = KivoTheme.typography.BodyMedium,
            color = KivoTheme.colors.onSurfaceVariant,
        )
        TextButton(onClick = onSignUpClick) {
            Text(
                text = "Sign Up",
                style = KivoTheme.typography.BodyMedium,
                color = KivoTheme.colors.primary,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}
