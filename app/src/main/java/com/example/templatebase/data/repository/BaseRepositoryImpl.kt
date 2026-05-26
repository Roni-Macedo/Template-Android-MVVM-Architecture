package com.example.templatebase.data.repository

import com.example.templatebase.data.local.BaseDao
import com.example.templatebase.data.mapper.toDomain
import com.example.templatebase.data.mapper.toEntity
import com.example.templatebase.domain.model.Base
import com.example.templatebase.domain.repository.BaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BaseRepositoryImpl(
    private val dao: BaseDao
) : BaseRepository {
    override suspend fun insert(base: Base) {
        dao.insert(base.toEntity())
    }

    override suspend fun update(base: Base) {
        dao.update(base.toEntity())
    }

    override suspend fun delete(base: Base) {
        dao.delete(base.toEntity())
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override fun getAll(): Flow<List<Base>> {
        return dao.getAll().map { list ->
            list.map { it.toDomain() }
        }
    }

}
