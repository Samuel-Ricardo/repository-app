package com.study.kotlin.repository_app.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.study.kotlin.repository_app.domain.ListUserRepositoriesUseCase

class MainViewModel(
    private val listUserRepositoriesUseCase: ListUserRepositoriesUseCase
): ViewModel() {
}