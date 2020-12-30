package com.fernandes.fernandes4a.domain.usecase

import com.fernandes.fernandes4a.data.repository.UserRepository
import com.fernandes.fernandes4a.domain.entity.User

class GetUserUseCase(
    private val userRepository:UserRepository//: UserRepository
) {
    suspend fun invoke(email: String) : User? {
        return userRepository.getUser(email)

    }
}