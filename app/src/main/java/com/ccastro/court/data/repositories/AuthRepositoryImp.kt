package com.ccastro.court.data.repositories

import com.ccastro.court.domain.models.Response
import com.ccastro.court.domain.models.User
import com.ccastro.court.domain.repositories.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(private val firebaseAuth: FirebaseAuth) : AuthRepository {

    override val currentUser: FirebaseUser? get() = firebaseAuth.currentUser
    override suspend fun login(email: String, password: String): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Response.Success(result.user)
        }catch (e: Exception) {
            e.printStackTrace()
            Response.Fail(e)
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }

    override suspend fun singUp(user: User, password: String): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(user.email, password).await()
            Response.Success(result.user)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Fail(e)
        }
    }
}