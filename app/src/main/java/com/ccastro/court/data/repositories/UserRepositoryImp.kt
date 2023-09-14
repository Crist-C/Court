package com.ccastro.court.data.repositories

import android.util.Log
import com.ccastro.court.domain.models.Response
import com.ccastro.court.domain.models.User
import com.ccastro.court.domain.repositories.UserRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class UserRepositoryImp @Inject constructor(@Named("UserCollection") private val userCollection: CollectionReference) : UserRepository {
    override suspend fun createUser(user: User): Response<Boolean> {
        return try {
            userCollection.document(user.id).set(user).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("APPLOG", "Error User Create Response: ${e.printStackTrace()}")
            Response.Fail(e)
        }
    }

    override fun getUserById(id: String): Flow<User> = callbackFlow {
        val snapshotListener = userCollection.document(id).addSnapshotListener{
            snapshot, e ->
            val user = snapshot?.toObject(User::class.java) ?: User()
            trySend(user)
        }
        awaitClose{
            snapshotListener.remove()
        }
    }
}