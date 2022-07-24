package com.pablo.study.local_database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.material.textfield.TextInputEditText

@Entity(tableName = "countryentity")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id")
    var id: Int? = null,
    @ColumnInfo(name = "user")
    val countryCode: String,
    @ColumnInfo(name = "password")
    val countryDescription: String,
)