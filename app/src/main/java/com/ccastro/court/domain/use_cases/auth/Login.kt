package com.ccastro.court.domain.use_cases.auth

import com.ccastro.court.domain.repositories.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)

}