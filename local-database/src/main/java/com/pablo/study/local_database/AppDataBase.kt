package com.pablo.study.local_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pablo.study.local_database.model.LoginEntity

@Database(entities = [LoginEntity::class], version = 1, exportSchema = false)

abstract class AppDataBase : RoomDatabase() {
    abstract fun appDao(): AppDao
}