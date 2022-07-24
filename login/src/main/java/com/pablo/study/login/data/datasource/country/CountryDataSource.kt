package com.pablo.study.login.data.datasource.country

import com.pablo.study.local_database.model.CountryEntity

// Data Source Acess local data
interface CountryDataSource {
    suspend fun saveCountry(countryModel: CountryEntity)
}