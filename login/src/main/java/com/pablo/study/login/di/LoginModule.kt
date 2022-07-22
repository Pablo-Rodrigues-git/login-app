package com.pablo.study.login.di

import com.pablo.study.login.LoginNavigationImpl
import com.pablo.study.navigation.LoginNavigation
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class LoginModule {
    private val navigationModule = module {
        single<LoginNavigation> { LoginNavigationImpl() }
    }

    private val loginModules = navigationModule
//    + dataModule + domainModule +
//            presentationModule + retrofitModule

    fun load() {
        loadKoinModules(loginModules)
    }
}