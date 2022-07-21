package com.pablo.study.login

import android.content.Context
import android.content.Intent
import com.pablo.study.navigation.LoginNavigation

class LoginNavigationImpl : LoginNavigation {
    override fun getLoginIntent(context: Context): Intent = LoginActivity.getIntent(context)
}