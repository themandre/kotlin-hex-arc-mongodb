package com.mandre.kha.users.infrastructure.adapters.output.persistence.repository

import com.mandre.kha.users.infrastructure.adapters.output.persistence.entity.UserDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<UserDocument, String>