package com.example.templatebase.domain.repository

import com.example.templatebase.domain.model.Base
import kotlinx.coroutines.flow.Flow

interface BaseRepository {

    suspend fun insert(base: Base)
    suspend fun update(base: Base)
    suspend fun delete(base: Base)
    suspend fun deleteAll()

    fun getAll(): Flow<List<Base>>
}