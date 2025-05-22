package com.josedev.splitit.domain

import com.google.firebase.auth.FirebaseUser

data class AuthState(
    val user: FirebaseUser? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
