package com.pablo.study.navigation

import android.content.Context
import android.content.Intent

interface RegisterNavigation {
    fun getRegisterIntent(context: Context): Intent
}