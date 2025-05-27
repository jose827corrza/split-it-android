package com.josedev.splitit.repository.storage

import com.josedev.splitit.domain.entities.Project
import com.josedev.splitit.utils.Resource

interface StorageRepository {

    suspend fun getAllProjects(): Resource<List<Project>>
    suspend fun createAProject()
    suspend fun deleteAProject()
}