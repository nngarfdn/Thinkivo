package org.mob.thinkivo.features.login.presentation

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()

    data class PasswordChanged(val password: String) : LoginEvent()

    object TogglePasswordVisibility : LoginEvent()

    object Login : LoginEvent()

    object ForgotPassword : LoginEvent()

    object SignUp : LoginEvent()

    object GoogleLogin : LoginEvent()
}
