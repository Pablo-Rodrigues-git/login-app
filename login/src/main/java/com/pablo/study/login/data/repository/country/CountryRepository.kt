package com.pablo.study.login.data.repository.country

// Repository acess data source and send correct or error data
interface CountryRepository {
    suspend fun saveCountry(countryModel: CountryModel)
}