package com.example.templatebase.ui.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.templatebase.domain.model.Base
import com.example.templatebase.domain.repository.BaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class BaseViewModel @Inject constructor(
    private val repository: BaseRepository
) : ViewModel() {

    val works = repository.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun salvar(local: String) {
        val hoje = LocalDate.now()

        val work = Base(
            id = 0,
            local = local,
            date = hoje.toString(),
            dayOfWeek = hoje.dayOfWeek.name
        )

        viewModelScope.launch {
            repository.insert(work)
        }
    }

    fun deletar(work: Base) {
        viewModelScope.launch {
            repository.delete(work)
        }
    }

    fun atualizar(work: Base) {
        viewModelScope.launch {
            repository.update(work)
        }
    }

    fun deletarTudo() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}
