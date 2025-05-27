package com.josedev.splitit.domain.entities

import com.google.firebase.Timestamp

data class Project (
    val name: String,
    val members: List<String>,
    val createdAt: Timestamp,
)