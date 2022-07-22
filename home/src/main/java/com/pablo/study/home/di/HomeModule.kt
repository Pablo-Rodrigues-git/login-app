package com.pablo.study.home.di

import com.pablo.study.home.HomeNavigationImpl
import com.pablo.study.navigation.HomeNavigation
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class HomeModule {
    private val navigationModule = module {
        single<HomeNavigation> { HomeNavigationImpl() }
    }

    private val homeModules = navigationModule
//    + dataModule + domainModule +
//            presentationModule + retrofitModule

    fun load() {
        loadKoinModules(homeModules)
    }
}