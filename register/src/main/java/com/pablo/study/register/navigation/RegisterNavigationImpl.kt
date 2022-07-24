package com.pablo.study.register.navigation

import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import com.pablo.study.navigation.RegisterNavigation
import com.pablo.study.register.presentation.RegisterActivity

class RegisterNavigationImpl : RegisterNavigation {
    override fun getCountryIntent(context: Context): Intent = RegisterActivity.getIntent(context)
    override fun getClientIntent(context: Context): Intent = RegisterActivity.getIntent(context)
}