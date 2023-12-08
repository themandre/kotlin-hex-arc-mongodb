package com.mandre.kha.users.infrastructure.adapters.output.persistence

import com.mandre.kha.users.application.ports.output.UserOutputPort
import com.mandre.kha.users.domain.model.User
import com.mandre.kha.users.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper
import com.mandre.kha.users.infrastructure.adapters.output.persistence.repository.UserRepository

class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userPersistenceMapper: UserPersistenceMapper
) : UserOutputPort {

    override fun createUser(user: User): User {
        var userDocument = userPersistenceMapper.toUserDocument(user)
        userDocument = userRepository.save(userDocument)
        return userPersistenceMapper.toUser(userDocument)
    }

    override fun deleteUser(id: String) {
        userRepository.deleteById(id)
    }

    override fun findAll(): List<User> {
        return userRepository.findAll().map { userPersistenceMapper.toUser(it) }
    }

    override fun findOne(id: String): User? {
        return userRepository.findById(id).map { userPersistenceMapper.toUser(it) }.orElse(null)
    }

    override fun updateUser(user: User): User {
        return userRepository.save(userPersistenceMapper.toUserDocument(user)).let { userPersistenceMapper.toUser(it) }
    }
}