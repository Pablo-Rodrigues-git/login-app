package com.pablo.study.local_database.di

import androidx.room.Room
import com.pablo.study.local_database.AppDao
import com.pablo.study.local_database.AppDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class LocalDatabaseModule {

    private val localDatabaseModule = module {

        single {
            Room
                .databaseBuilder(
                    androidApplication(),
                    AppDataBase::class.java,
                    DATABASE_NAME
                )
                .build()
        }

        single { provideRedditImageDao(get()) }
    }

    private fun provideRedditImageDao(database: AppDataBase): AppDao {
        return database.appDao()
    }

    fun load() {
        loadKoinModules(localDatabaseModule)
    }

    companion object {
        const val DATABASE_NAME = "appdatabase.db"
    }
}


