package com.pablo.study.navigation

import android.content.Context
import android.content.Intent

interface RegisterNavigation {
    fun getCountryIntent(context: Context): Intent
    fun getClientIntent(context: Context): Intent
}