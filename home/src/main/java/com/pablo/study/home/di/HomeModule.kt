package com.pablo.study.home.di

import com.pablo.study.home.HomeNavigationImpl
import com.pablo.study.navigation.HomeNavigation
import com.pablo.study.navigation.RegisterNavigation
import com.pablo.study.register.navigation.RegisterNavigationImpl
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class HomeModule {
    private val navigateToHome = module {
        single<HomeNavigation> { HomeNavigationImpl() }
    }

    private val homeModules = navigateToHome
//    + dataModule + domainModule +
//            presentationModule + retrofitModule

    fun load() {
        loadKoinModules(homeModules)
    }
}