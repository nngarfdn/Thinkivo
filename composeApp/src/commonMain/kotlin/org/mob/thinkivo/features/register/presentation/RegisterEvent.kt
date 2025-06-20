package org.mob.thinkivo.features.register.presentation

sealed class RegisterEvent {
    data class FullNameChanged(val fullName: String) : RegisterEvent()

    data class EmailChanged(val email: String) : RegisterEvent()

    data class PasswordChanged(val password: String) : RegisterEvent()

    data class ConfirmPasswordChanged(val confirmPassword: String) : RegisterEvent()

    object TogglePasswordVisibility : RegisterEvent()

    object ToggleConfirmPasswordVisibility : RegisterEvent()

    object Register : RegisterEvent()

    object Login : RegisterEvent()

    object GoogleLogin : RegisterEvent()
} 
