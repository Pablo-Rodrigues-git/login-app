package com.pablo.study.register.di

import com.pablo.study.navigation.RegisterNavigation
import com.pablo.study.register.data.datasource.RegisterDataSource
import com.pablo.study.register.data.datasource.RegisterDataSourceImpl
import com.pablo.study.register.data.repository.RegisterRepository
import com.pablo.study.register.data.repository.RegisterRepositoryImpl
import com.pablo.study.register.navigation.RegisterNavigationImpl
import com.pablo.study.register.presentation.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.dsl.module

class RegisterModule {

    private val navigationModule = module {
        single<RegisterNavigation> { RegisterNavigationImpl() }
    }

    private val dataSource = module {
        factory<RegisterDataSource> { RegisterDataSourceImpl(get()) }
    }

    private val registerRepository = module {
        factory<RegisterRepository> { RegisterRepositoryImpl(get()) }
    }

    private val presentationModule = module {
        viewModel {
            RegisterViewModel(get())
        }
    }

    private val registerModules =
        navigationModule + dataSource +
                registerRepository +
                presentationModule

    fun load() {
        loadKoinModules(registerModules)
    }
}