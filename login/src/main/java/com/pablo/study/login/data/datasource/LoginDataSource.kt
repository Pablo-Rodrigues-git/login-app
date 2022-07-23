package com.pablo.study.login.data.datasource

import com.pablo.study.local_database.model.LoginEntity

// Data Source Acess local data
interface LoginDataSource {
    suspend fun saveCredentials(loginModel: LoginEntity)
}