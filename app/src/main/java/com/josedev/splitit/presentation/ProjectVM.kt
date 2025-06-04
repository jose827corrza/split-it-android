package com.josedev.splitit.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josedev.splitit.domain.states.ProjectState
import com.josedev.splitit.repository.events.ProjectEvent
import com.josedev.splitit.repository.storage.StorageRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectVM @Inject constructor(
    private val storageRepository: StorageRepositoryImpl
): ViewModel() {

    private val _state = MutableStateFlow(ProjectState())
    val state: StateFlow<ProjectState> = _state.asStateFlow()

    fun onEvent(event: ProjectEvent){
        when(event){
            is ProjectEvent.GetProjectInformation -> {
                viewModelScope.launch {
                    val result = storageRepository.getProjectInformation(event.projectId)
                    if(result.data!=null){
                        _state.update {
                            it.copy(
                                project = result.data,
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