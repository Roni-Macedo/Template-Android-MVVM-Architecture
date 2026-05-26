package com.example.templatebase.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BaseDao {

    @Insert
    suspend fun insert(base: BaseEntity)

    @Update
    suspend fun update(base: BaseEntity)

    @Delete
    suspend fun delete(base: BaseEntity)

    @Query("DELETE FROM base")
    suspend fun deleteAll()

    @Query("SELECT * FROM base ORDER BY id DESC")
    fun getAll(): Flow<List<BaseEntity>>
}
