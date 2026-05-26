package com.example.templatebase.di

import android.app.Application
import androidx.room.Room
import com.example.templatebase.data.local.AppDatabase
import com.example.templatebase.data.local.BaseDao
import com.example.templatebase.data.repository.BaseRepositoryImpl
import com.example.templatebase.domain.repository.BaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "base_db"
        ).build()
    }

    @Provides
    fun provideDao(db: AppDatabase): BaseDao {
        return db.baseDao()
    }

    @Provides
    fun provideRepository(dao: BaseDao): BaseRepository {
        return BaseRepositoryImpl(dao)
    }
}
