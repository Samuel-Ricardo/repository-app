package com.study.kotlin.repository_app.core.contract

import com.study.kotlin.repository_app.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repo>>
}