package com.pablo.study.login.di

import com.pablo.study.login.presentation.LoginViewModel
import com.pablo.study.login.data.datasource.login.LoginDataSource
import com.pablo.study.login.data.datasource.login.LoginDataSourceImpl
import com.pablo.study.login.data.repository.login.LoginRepository
import com.pablo.study.login.data.repository.login.LoginRepositoryImpl
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

    private val loginRepository = module {
        factory<LoginRepository> { LoginRepositoryImpl(get()) }
    }

    private val presentationModule = module {
        viewModel {
            LoginViewModel(get())
        }
    }

    private val loginModules =
        navigationModule + dataSource +
                loginRepository +
                presentationModule

    fun load() {
        loadKoinModules(loginModules)
    }
}