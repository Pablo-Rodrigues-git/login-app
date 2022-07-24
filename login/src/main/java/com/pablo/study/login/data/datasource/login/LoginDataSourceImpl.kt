package com.pablo.study.login.data.datasource.login

import com.pablo.study.local_database.AppDao
import com.pablo.study.local_database.model.LoginEntity

class LoginDataSourceImpl(
    private val localData: AppDao,
) : LoginDataSource {
    override suspend fun saveCredentials(loginModel: LoginEntity) =
        localData.saveCredentials(loginModel)
}