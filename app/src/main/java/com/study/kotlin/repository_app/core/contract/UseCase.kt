package com.study.kotlin.repository_app.core.contract

import kotlinx.coroutines.flow.Flow
import java.lang.UnsupportedOperationException

abstract class UseCase<Param, Source> {

    object None;

    abstract suspend fun execute(param: Param): Flow<Source>

    open suspend operator fun invoke(param: Param) = execute(param)

    abstract class NoParam<Source>: UseCase<None, Flow<Source>>() {
        abstract suspend fun execute(): Flow<Source>

        final override suspend fun execute(param: None) = throw UnsupportedOperationException()

        suspend operator fun invoke(): Flow<Source> = execute()
    }

    abstract class NoSource<Params>: UseCase<Params, Unit>() {
        override suspend fun invoke(param: Params) = execute(param)
    }

}