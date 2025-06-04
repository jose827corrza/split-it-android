package com.josedev.splitit.repository.storage

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.josedev.splitit.domain.entities.Project
import com.josedev.splitit.util.Constants
import com.josedev.splitit.utils.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
): StorageRepository {
    override suspend fun getAllProjects(): Resource<List<Project>> {
        val projects: MutableList<Project> = mutableListOf()

        try {
            val query = firestore.collection(Constants.PROJECTS_COLLECTION)
                .whereArrayContains("members", auth.currentUser!!.uid)
                .get()
                .await()

            for (document in query.documents){
                val project = document.toObject(Project::class.java)
                if (project != null) {
                    project.projectId = document.id
                    projects.add(project)
                }
            }
            return Resource.Success(projects)
        }
        catch (e: Exception) {
            return Resource.Error(null, e.message)
        }
    }

    override suspend fun getProjectInformation(projectId: String): Resource<Project> {
        try {
            val query = firestore.collection(Constants.PROJECTS_COLLECTION)
                .document(projectId)
                .get()
                .await()

            if(query.data == null){
                throw Exception("Project not found")
            }
            val project = query.toObject(Project::class.java)
            return Resource.Success(project)
        }
        catch (e: Exception){
            return Resource.Error(null, e.message)
        }
    }

    override suspend fun createAProject(): Boolean {
        // TODO
        return true
    }

    override suspend fun deleteAProject(): Boolean {
        // TODO
        return true
    }
}