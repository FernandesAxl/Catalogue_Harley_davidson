package com.fernandes.fernandes4a.domain.usecase

import com.fernandes.fernandes4a.data.repository.UserRepository
import com.fernandes.fernandes4a.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreateUserUseCaseTest {
    private val userRepository:UserRepository = mockk()

    private val classUnderTest = CreateUserUseCase(userRepository)

    @Test
    fun resendMailSucces() {
        runBlocking {
            //GIVEN
            val user = User("")
            coEvery { userRepository.createUser(user) } returns Unit

            //WHEN
            classUnderTest.invoke(user)

            //THEN
            coVerify(exactly = 1) { userRepository.createUser(user)}
        }
    }
}