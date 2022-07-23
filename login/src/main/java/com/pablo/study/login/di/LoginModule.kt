package com.pablo.study.login.di

import com.pablo.study.login.LoginViewModel
import com.pablo.study.login.data.datasource.LoginDataSource
import com.pablo.study.login.data.datasource.LoginDataSourceImpl
import com.pablo.study.login.data.repository.LoginRepository
import com.pablo.study.login.data.repository.LoginRepositoryImpl
import com.pablo.study.login.navigation.LoginNavigationImpl
import com.pablo.study.navigation.LoginNavigation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class LoginModule {
    private val navigationModule = module {
        single<LoginNavigation> { LoginNavigationImpl() }
    }

    private val dataSource = module {
        factory<LoginDataSource> { LoginDataSourceImpl(get()) }
    }

    private val repository = module {
        factory<LoginRepository> { LoginRepositoryImpl(get()) }
    }

    private val presentationModule = module {
        viewModel {
            LoginViewModel(get())
        }
    }

    private val loginModules = navigationModule + dataSource + repository + presentationModule

    fun load() {
        loadKoinModules(loginModules)
    }
}