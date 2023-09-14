package com.ccastro.court.domain.repositories

import com.ccastro.court.domain.models.Response
import com.ccastro.court.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun createUser(user: User): Response<Boolean>

    fun getUserById(id: String): Flow<User>
}