package com.josedev.splitit.repository.storage

import com.josedev.splitit.domain.entities.Project
import com.josedev.splitit.utils.Resource

interface StorageRepository {

    suspend fun getAllProjects(): Resource<List<Project>>
    suspend fun getProjectInformation(projectId: String): Resource<Project>
    suspend fun createAProject(): Boolean
    suspend fun deleteAProject(): Boolean
}