package com.pablo.study.register.data.repository

// Repository acess data source and send correct or error data
interface RegisterRepository {
    suspend fun saveCountry(registerModel: RegisterModel)
}