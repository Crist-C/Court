package com.ccastro.court.domain.repositories

import com.ccastro.court.domain.models.Response
import com.ccastro.court.domain.models.User
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Response<FirebaseUser>
    fun logout()
    suspend fun singUp(user: User, password: String): Response<FirebaseUser>

    // Con retrofit la respuesta sería un Json u otro tipo
    //fun login(email: String, password: String): Response<FirebaseUser>

}