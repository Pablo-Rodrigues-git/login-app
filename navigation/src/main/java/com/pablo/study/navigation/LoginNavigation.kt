package com.pablo.study.navigation

import android.content.Context
import android.content.Intent

interface LoginNavigation {
    fun getLoginIntent(context: Context): Intent
}