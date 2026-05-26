package com.example.templatebase.data.mapper

import com.example.templatebase.data.local.BaseEntity
import com.example.templatebase.domain.model.Base

fun BaseEntity.toDomain() = Base(id, local, date, dayOfWeek)

fun Base.toEntity() = BaseEntity(id, local, date, dayOfWeek)
