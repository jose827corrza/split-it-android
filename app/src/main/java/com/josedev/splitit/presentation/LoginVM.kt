package com.josedev.splitit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josedev.splitit.domain.AuthState
import com.josedev.splitit.repository.auth.AuthRepositoryImpl
import com.josedev.splitit.repository.events.AuthEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor(
    private val authRepository: AuthRepositoryImpl
): ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()

    fun onEvent(event: AuthEvent){
        when(event){
            is AuthEvent.Login -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _state.value = state.value.copy(isLoading = true)
                    val result = authRepository.logIn(event.email, event.password)
                    if(result.data != null){
                        _state.value = state.value.copy(user = result.data)
                    } else {
                        _state.value = state.value.copy(error = result.message, user = null)
                    }
                    _state.value = state.value.copy(isLoading = false)
                }
            }
            is AuthEvent.SignUp -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _state.value = state.value.copy(isLoading = true)
                    val result = authRepository.signUp(event.email, event.password)
                    if(result.data != null){
                        _state.value = state.value.copy(user = result.data)
                    } else {
                        _state.value = state.value.copy(error = result.message, user = null)
                    }
                    _state.value = state.value.copy(isLoading = false)
                }
            }
            is AuthEvent.SignOut -> {
                authRepository.signOut()
            }
        }
    }
}