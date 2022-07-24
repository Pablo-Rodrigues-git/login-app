package com.pablo.study.register.data.datasource

import com.pablo.study.local_database.model.CountryEntity

// Data Source Acess local data
interface RegisterDataSource {
    suspend fun saveCountry(countryModel: CountryEntity)
}