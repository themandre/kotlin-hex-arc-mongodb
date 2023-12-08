package com.mandre.kha.users.infrastructure.adapters.output.persistence.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class UserDocument(
    @Id
    val id: ObjectId,
    val username: String,
    var password: String,
    val email: String,
    val name: String,
    val lastName: String
)