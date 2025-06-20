package org.mob.thinkivo.features.register.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val fullName: String,
    val email: String,
    val password: String,
)
