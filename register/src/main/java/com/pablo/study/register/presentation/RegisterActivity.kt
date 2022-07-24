package com.pablo.study.register.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pablo.study.navigation.LoginNavigation
import com.pablo.study.navigation.RegisterNavigation
import com.pablo.study.navigation.startNewActivityAndFinish
import com.pablo.study.register.R
import org.koin.android.ext.android.inject

class RegisterActivity : AppCompatActivity() {
    private val nav: RegisterNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        startNewActivityAndFinish(nav.getCountryIntent(this))
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }
}