package com.pablo.study.login.data.datasource.country

import com.pablo.study.local_database.AppDao
import com.pablo.study.local_database.model.CountryEntity

class CountryDataSourceImpl(
    private val localData: AppDao,
) : CountryDataSource {
    override suspend fun saveCountry(countryModel: CountryEntity) =
        localData.saveCountry(countryModel)

}