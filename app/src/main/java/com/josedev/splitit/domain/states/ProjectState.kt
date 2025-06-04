package com.josedev.splitit.domain.states

import com.josedev.splitit.domain.entities.Project

data class ProjectState(
    val project: Project = Project(),
    val isLoading: Boolean = true
)