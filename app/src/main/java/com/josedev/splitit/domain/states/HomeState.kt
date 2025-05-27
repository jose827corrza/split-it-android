package com.josedev.splitit.domain.states

import com.josedev.splitit.domain.entities.Project

data class HomeState(
    val projects: List<Project> = emptyList(),
    val isLoading: Boolean = true
)