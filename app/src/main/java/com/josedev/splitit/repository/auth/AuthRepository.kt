package com.josedev.splitit.repository.auth

import com.google.firebase.auth.FirebaseUser
import com.josedev.splitit.utils.Resource

interface AuthRepository {

    suspend fun signUp(email: String, password: String): Resource<FirebaseUser>
    suspend fun logIn(email: String, password: String): Resource<FirebaseUser>
    fun signOut()
}