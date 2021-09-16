package com.study.kotlin.repository_app.domain

import com.study.kotlin.repository_app.core.contract.RepoRepository
import com.study.kotlin.repository_app.core.contract.UseCase
import com.study.kotlin.repository_app.data.model.Repo
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase (
    private val repository: RepoRepository
): UseCase<String, List<Repo>>(){
    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }
}