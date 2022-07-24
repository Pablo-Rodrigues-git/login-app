package com.pablo.study.login_app

import android.app.Application
import com.pablo.study.home.di.HomeModule
import com.pablo.study.local_database.di.LocalDatabaseModule
import com.pablo.study.login.di.LoginModule
import com.pablo.study.register.di.RegisterModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationApp)
            LocalDatabaseModule().load()
            LoginModule().load()
            HomeModule().load()
            RegisterModule().load()
        }
    }
}