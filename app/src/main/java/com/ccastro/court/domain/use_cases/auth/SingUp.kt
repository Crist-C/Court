package com.ccastro.court.domain.use_cases.auth

import com.ccastro.court.domain.models.User
import com.ccastro.court.domain.repositories.AuthRepository
import javax.inject.Inject

class SingUp @Inject constructor(private val repository: AuthRepository){

    suspend operator fun invoke(user: User, password: String) = repository.singUp(user, password)
}