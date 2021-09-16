package com.study.kotlin.repository_app.core.contract

import kotlinx.coroutines.flow.Flow

abstract class UseCase<Param, Source> {

    abstract suspend fun execute(param: Param): Flow<Source>

    open suspend operator fun invoke(param: Param) = execute(param)

}
