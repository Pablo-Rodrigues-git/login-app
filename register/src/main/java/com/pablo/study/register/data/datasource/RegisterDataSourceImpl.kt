package com.pablo.study.register.data.datasource

import com.pablo.study.local_database.AppDao
import com.pablo.study.local_database.model.CountryEntity

class RegisterDataSourceImpl(
    private val localData: AppDao,
) : RegisterDataSource {
    override suspend fun saveCountry(countryModel: CountryEntity) =
        localData.saveCountry(countryModel)

}