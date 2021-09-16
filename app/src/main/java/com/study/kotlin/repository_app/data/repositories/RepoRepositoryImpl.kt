package com.study.kotlin.repository_app.data.repositories

import com.study.kotlin.repository_app.core.contract.RepoRepository
import com.study.kotlin.repository_app.core.exception.RemoteException
import com.study.kotlin.repository_app.data.model.Repo
import com.study.kotlin.repository_app.data.services.GitHubService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: GitHubService): RepoRepository {

    override suspend fun listRepositories(user: String): = flow {
        try {
            val repoList = service.listRepositories((user))
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possivel fazer a busca no momento!")
        }
    }
}