package com.josedev.splitit.repository.events

sealed interface AuthEvent {
    data class Login(val email: String, val password: String): AuthEvent
    data class SignUp(val email: String, val password: String): AuthEvent
    data object SignOut: AuthEvent
}