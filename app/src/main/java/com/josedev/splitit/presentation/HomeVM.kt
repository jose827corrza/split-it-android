package com.josedev.splitit.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josedev.splitit.domain.states.HomeState
import com.josedev.splitit.repository.events.HomeEvent
import com.josedev.splitit.repository.storage.StorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val storageRepository: StorageRepository
): ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    fun onEvent(event: HomeEvent){
        when(event){
            is HomeEvent.getAllProjects -> {
                viewModelScope.launch {
                    val result = storageRepository.getAllProjects()
                    if(result.data!=null){
                        _state.update {
                            it.copy(
                                projects = result.data,
                                isLoading = false
                            )
                        }
                    }else {
                        _state.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }
}