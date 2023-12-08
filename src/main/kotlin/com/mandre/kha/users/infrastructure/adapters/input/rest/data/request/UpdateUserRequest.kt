package com.mandre.kha.users.infrastructure.adapters.input.rest.data.request

data class UpdateUserRequest(
    val id: String,
    val username: String,
    val password: String,
    val email: String,
    val name: String,
    val lastName: String
)
