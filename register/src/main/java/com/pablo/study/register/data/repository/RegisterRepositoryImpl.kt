package com.pablo.study.register.data.repository

import com.pablo.study.local_database.model.CountryEntity
import com.pablo.study.register.data.datasource.RegisterDataSource

class RegisterRepositoryImpl(
    private val dataSource: RegisterDataSource,
) : RegisterRepository {

    override suspend fun saveCountry(registerModel: RegisterModel) {
        val countryEntity = map(registerModel)
        return dataSource.saveCountry(countryEntity)
    }

    private fun map(data: RegisterModel): CountryEntity {
        return CountryEntity(
            countryCode = data.email,
            countryDescription = data.password
        )
    }
}