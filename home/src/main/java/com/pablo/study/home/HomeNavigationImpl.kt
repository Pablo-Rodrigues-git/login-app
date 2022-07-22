package com.pablo.study.home

import android.content.Context
import android.content.Intent
import com.pablo.study.navigation.HomeNavigation

class HomeNavigationImpl : HomeNavigation {
    override fun getHomeIntent(context: Context): Intent = HomeActivity.getIntent(context)
}