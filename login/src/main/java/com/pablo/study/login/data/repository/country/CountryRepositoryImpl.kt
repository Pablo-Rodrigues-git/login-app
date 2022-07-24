package com.pablo.study.login.data.repository.country

import com.pablo.study.local_database.model.CountryEntity
import com.pablo.study.login.data.datasource.country.CountryDataSource

class CountryRepositoryImpl(
    private val dataSource: CountryDataSource,
) : CountryRepository {

    override suspend fun saveCountry(countryModel: CountryModel) {
        val countryEntity = map(countryModel)
        return dataSource.saveCountry(countryEntity)
    }

    private fun map(data: CountryModel): CountryEntity {
        return CountryEntity(
            countryCode = data.countryCode,
            countryDescription = data.countryDescription
        )
    }
}