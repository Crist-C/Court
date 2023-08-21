package com.ccastro.court.domain.use_cases.auth

import com.ccastro.court.domain.repositories.AuthRepository
import javax.inject.Inject

class Logout @Inject constructor(private val repository: AuthRepository){

    operator fun invoke() = repository.logout()
}
