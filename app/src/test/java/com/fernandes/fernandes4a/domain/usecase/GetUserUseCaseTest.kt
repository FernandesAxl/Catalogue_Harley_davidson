package com.fernandes.fernandes4a.domain.usecase

import com.fernandes.fernandes4a.data.repository.UserRepository
import com.fernandes.fernandes4a.domain.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest {
    private val userRepository:UserRepository = mockk()

    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email`() {
        runBlocking {
            //GIVEN
            val email = ""
            coEvery { userRepository.getUser(email) } returns null

            //WHEN
            val result :User? = classUnderTest.invoke(email)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email) }
            assertEquals(result, null)

        }
    }

    @Test
    fun `invoke with valid email`() {
        runBlocking {
            //GIVEN
            val email = ""
            val expectedUser = User ("")
            coEvery { userRepository.getUser(email) } returns User("")

            //WHEN
            val result :User? = classUnderTest.invoke(email)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email) }
            assertEquals(result, expectedUser)

        }
    }
}