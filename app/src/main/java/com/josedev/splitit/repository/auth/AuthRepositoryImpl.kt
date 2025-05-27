package com.josedev.splitit.repository.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.josedev.splitit.utils.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
): AuthRepository {
    override suspend fun signUp(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password)
                .await()
            Resource.Success(result.user)
        } catch (e: Exception){
            return Resource.Error(null, e.message)
        }
    }

    override suspend fun logIn(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password)
                .await()
            Resource.Success(result.user)
        } catch (e: Exception){
            return Resource.Error(null, e.message)
        }
    }

    override fun signOut() {
        auth.signOut()
    }
}