package com.pablo.study.local_database.model

import android.widget.EditText
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loginEntity")
data class LoginEntity(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "id")
    var id: Int? = null,
    @ColumnInfo(name = "user")
    val user: String,
    @ColumnInfo(name = "password")
    val password: String,
)