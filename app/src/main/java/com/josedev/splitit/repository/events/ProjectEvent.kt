package com.josedev.splitit.repository.events

interface ProjectEvent {
    data class GetProjectInformation(val projectId: String): ProjectEvent
}