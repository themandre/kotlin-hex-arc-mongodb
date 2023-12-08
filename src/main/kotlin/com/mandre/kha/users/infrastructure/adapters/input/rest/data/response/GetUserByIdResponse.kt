package com.mandre.kha.users.infrastructure.adapters.input.rest.data.response

data class GetUserByIdResponse(
    val id: String,
    val username: String,
    val email: String,
)
