package com.josedev.splitit.repository.storage

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.josedev.splitit.domain.entities.Project
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
            val query = firestore.collection("projects")
                .whereArrayContains("members", auth.currentUser!!.uid)
                .get()
                .await()

            for (document in query.documents){
                val project = document.toObject(Project::class.java)
                if (project != null){
                    projects.add(project)
                    }
            }
            return Resource.Success(projects)
        }
        catch (e: Exception) {
            Log.e("STORAGE", e.message.toString())
            return Resource.Error(null, e.message)
        }
    }

    override suspend fun createAProject() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAProject() {
        TODO("Not yet implemented")
    }
}