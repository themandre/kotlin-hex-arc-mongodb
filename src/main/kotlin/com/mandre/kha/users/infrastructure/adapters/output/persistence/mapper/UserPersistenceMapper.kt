package com.mandre.kha.users.infrastructure.adapters.output.persistence.mapper

import com.mandre.kha.users.domain.model.User
import com.mandre.kha.users.infrastructure.adapters.output.persistence.entity.UserDocument
import org.bson.types.ObjectId
import org.springframework.stereotype.Component

@Component
class UserPersistenceMapper {
    fun toUserDocument(user: User): UserDocument = UserDocument(
        id = user.id?.let { ObjectId(it) } ?: ObjectId(),
        username = user.username,
        password = user.password,
        email = user.email,
        name = user.name,
        lastName = user.lastName
    )

    fun toUser(userDocument: UserDocument): User = User(
        id = userDocument.id.toHexString(),
        username = userDocument.username,
        password = userDocument.password,
        email = userDocument.email,
        name = userDocument.name,
        lastName = userDocument.lastName
    )
}