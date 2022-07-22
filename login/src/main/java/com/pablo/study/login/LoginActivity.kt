package com.pablo.study.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pablo.study.navigation.HomeNavigation
import com.pablo.study.navigation.startNewActivity
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {
    private val nav: HomeNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        startNewActivity(nav.getHomeIntent(this))
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}