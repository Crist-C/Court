package com.ccastro.court.di

import com.ccastro.court.core.Constans.USER_COLLECTION
import com.ccastro.court.data.repositories.AuthRepositoryImp
import com.ccastro.court.data.repositories.UserRepositoryImp
import com.ccastro.court.domain.repositories.AuthRepository
import com.ccastro.court.domain.repositories.UserRepository
import com.ccastro.court.domain.use_cases.auth.AuthUseCases
import com.ccastro.court.domain.use_cases.auth.GetCurrentUser
import com.ccastro.court.domain.use_cases.auth.Login
import com.ccastro.court.domain.use_cases.auth.Logout
import com.ccastro.court.domain.use_cases.auth.SingUp
import com.ccastro.court.domain.use_cases.user.Create
import com.ccastro.court.domain.use_cases.user.GetUserById
import com.ccastro.court.domain.use_cases.user.UserUseCases
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Firebase: FireStore
    @Provides
    fun provideFireStore() : FirebaseFirestore = Firebase.firestore

    // Firebase: Authentication
    @Provides
    fun provideFirebaseAuth() : FirebaseAuth = FirebaseAuth.getInstance()

    // Firebase: FireStore: Collections
    @Provides
    @Named("UserCollection")
    fun provideUserCollectionsRef(db: FirebaseFirestore): CollectionReference = db.collection(USER_COLLECTION)

    // ------------------------------   Auth Repositories - Cases  -------------------------------- //
    @Provides
    fun providesAuthRepository(authRepositoryImp: AuthRepositoryImp) : AuthRepository = authRepositoryImp

    @Provides
    fun provideAuthUseCases(authRepository: AuthRepository) = AuthUseCases(
        singUp = SingUp(authRepository),
        login = Login(authRepository),
        logout = Logout(authRepository),
        getCurrentUser = GetCurrentUser(authRepository)
    )

    // ------------------------------   User Repositories - Cases  -------------------------------- //

    @Provides
    fun provideUserRepository(userRepositoryImp: UserRepositoryImp): UserRepository = userRepositoryImp

    @Provides
    fun providesUserUseCases(userRepository: UserRepository) = UserUseCases (
        create = Create(userRepository),
        getUserById = GetUserById(userRepository)
    )

}