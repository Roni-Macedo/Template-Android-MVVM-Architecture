package com.example.templatebase

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// 1. INJEÇÃO MANUAL (sem Hilt)

// Repository
class UserRepository {

    fun getUserName(): String {
        return "Ronivaldo"
    }
}

// ViewModel
class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    fun getName(): String {
        return repository.getUserName()
    }
}

// 2. COM HILT
// Agora o Hilt faz tudo automaticamente.
class UserRepositoryHilt @Inject constructor() {

    fun getUserName(): String {
        return "Guilherme"
    }
}

// ViewModel

@HiltViewModel
class UserViewModelHilt @Inject constructor(
    private val repository: UserRepositoryHilt
) : ViewModel() {

    fun getName(): String {
        return repository.getUserName()
    }
}

// Compose
@Composable
fun HomeScreen(
    viewModel: UserViewModelHilt = hiltViewModel()
) {

    Text(viewModel.getName())
}