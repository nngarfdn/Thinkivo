package org.mob.thinkivo.features.login.data.datasource.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: String,
    val fullName: String,
    val email: String,
    val token: String,
) 
