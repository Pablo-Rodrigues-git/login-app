package com.pablo.study.login.data.repository

// Repository acess data source and send correct or error data
interface LoginRepository {
    suspend fun saveLogin(loginModel: LoginModel)
}