package com.pablo.study.login_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pablo.study.navigation.LoginNavigation
import com.pablo.study.navigation.startNewActivityAndFinish
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val nav: LoginNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startNewActivityAndFinish(nav.getLoginIntent(this))
    }
}