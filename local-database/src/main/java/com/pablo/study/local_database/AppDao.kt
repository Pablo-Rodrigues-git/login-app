package com.pablo.study.local_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.pablo.study.local_database.model.CountryEntity
import com.pablo.study.local_database.model.LoginEntity

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCredentials(loginModel: LoginEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCountry(countryModel: CountryEntity)
}