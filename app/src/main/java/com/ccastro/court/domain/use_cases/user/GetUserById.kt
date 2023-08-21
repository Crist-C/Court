package com.ccastro.court.domain.use_cases.user

import com.ccastro.court.domain.repositories.UserRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val repository: UserRepository) {
    operator fun invoke(id: String) = repository.getUserById(id)
}