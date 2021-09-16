package com.study.kotlin.repository_app.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.study.kotlin.repository_app.data.model.Repo
import com.study.kotlin.repository_app.domain.ListUserRepositoriesUseCase

class MainViewModel(
    private val listUserRepositoriesUseCase: ListUserRepositoriesUseCase
): ViewModel() {


    sealed class State {
        object Loading: State()
        data class Success(val list: List<Repo>): State()
        data class Error(val error: Throwable): State()
    }
}