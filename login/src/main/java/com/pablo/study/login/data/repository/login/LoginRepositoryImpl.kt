package com.pablo.study.login.data.repository.login

import com.pablo.study.local_database.model.LoginEntity
import com.pablo.study.login.data.datasource.login.LoginDataSource

class LoginRepositoryImpl(
    private val dataSource: LoginDataSource,
): LoginRepository {

    override suspend fun saveLogin(loginModel: LoginModel) {
        val loginEntity = map(loginModel)
        return dataSource.saveCredentials(loginEntity)
    }

    private fun map(data: LoginModel): LoginEntity {
        return LoginEntity(
            user = data.user,
            password = data.password
        )
    }
}