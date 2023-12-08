package com.mandre.kha.users.domain.service

import com.mandre.kha.users.application.ports.input.*
import com.mandre.kha.users.application.ports.output.UserOutputPort
import com.mandre.kha.users.domain.model.User

class UserService(private val userOutputPort: UserOutputPort) :
    CreateUserUseCase,
    DeleteUserUseCase,
    FindAllUsersUseCase,
    FindOneUserUseCase,
    UpdateUserUseCase {

    val users = mutableListOf(
        User("1", "pepe", "pepe1234", "pepe@gmail.com", "Pepe", "Morales"),
        User("2", "juan", "juan1234", "juan@gmail.com", "Juan", "Morales")
    )

    override suspend fun create(user: User): User {
        return userOutputPort.createUser(user)
    }

    override suspend fun delete(id: String) {
        userOutputPort.deleteUser(id)
    }

    override suspend fun findAll(): List<User> = userOutputPort.findAll()

    override suspend fun findOne(id: String): User? = userOutputPort.findOne(id)

    override suspend fun update(user: User): User = userOutputPort.updateUser(user)
}
