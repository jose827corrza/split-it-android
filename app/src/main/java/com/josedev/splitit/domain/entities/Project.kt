package com.josedev.splitit.domain.entities

import com.google.firebase.Timestamp

data class Project (
    var projectId: String? = "",
    val name: String? = "",
    val members: List<String> = emptyList(),
    val createdAt: Timestamp? = Timestamp.now(),
)