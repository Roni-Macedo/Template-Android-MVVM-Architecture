package com.example.templatebase.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "base_db")
data class BaseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val local: String,
    val date: String,
    val dayOfWeek: String
)
