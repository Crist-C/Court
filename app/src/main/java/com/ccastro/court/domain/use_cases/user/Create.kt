package com.ccastro.court.domain.use_cases.user

import com.ccastro.court.domain.models.User
import com.ccastro.court.domain.repositories.UserRepository
import javax.inject.Inject

class Create @Inject constructor(private val userRepository: UserRepository){

    suspend operator fun invoke(user: User) = userRepository.createUser(user)
}