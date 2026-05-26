package com.example.templatebase.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BaseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun baseDao() : BaseDao
}
