package com.mandre.kha.users.infrastructure.adapters.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.mandre.kha.users.domain.service.UserService
import com.mandre.kha.users.infrastructure.adapters.output.persistence.UserPersistenceAdapter
import com.mandre.kha.users.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper
import com.mandre.kha.users.infrastructure.adapters.output.persistence.repository.UserRepository
import io.swagger.v3.core.jackson.ModelResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BeanConfiguration {

    @Bean
    fun userPersistenceAdapter(
        userRepository: UserRepository,
        userPersistenceMapper: UserPersistenceMapper
    ): UserPersistenceAdapter {
        return UserPersistenceAdapter(userRepository, userPersistenceMapper)
    }

    @Bean
    fun userService(userPersistenceAdapter: UserPersistenceAdapter): UserService {
        return UserService(userPersistenceAdapter)
    }

    @Bean
    fun modelResolver(objectMapper: ObjectMapper): ModelResolver {
        return ModelResolver(objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE))
    }
}