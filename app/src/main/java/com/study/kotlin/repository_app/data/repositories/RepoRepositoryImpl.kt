package com.study.kotlin.repository_app.data.repositories

import com.study.kotlin.repository_app.core.contract.RepoRepository
import com.study.kotlin.repository_app.data.services.GitHubService

class RepoRepositoryImpl(private val service: GitHubService): RepoRepository {


}