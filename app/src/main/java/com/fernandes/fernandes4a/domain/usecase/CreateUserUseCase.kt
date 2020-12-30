package com.fernandes.fernandes4a.domain.usecase

import com.fernandes.fernandes4a.data.repository.UserRepository
import com.fernandes.fernandes4a.domain.entity.User

class CreateUserUseCase(
    private val userRepository:UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)

    }
}
