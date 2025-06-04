package com.josedev.splitit.repository.events

sealed interface HomeEvent {
    data object GetAllProjects: HomeEvent
}