package com.mandre.kha.users.application.ports.output

import com.mandre.kha.users.domain.model.User

interface UserOutputPort {
    fun createUser(user: User): User
    fun deleteUser(id: String)
    fun findAll(): List<User>
    fun findOne(id: String): User?
    fun updateUser(user: User): User
}