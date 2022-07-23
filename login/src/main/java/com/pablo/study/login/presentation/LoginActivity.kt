package com.pablo.study.login.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pablo.study.login.databinding.ActivityLoginBinding
import com.pablo.study.navigation.HomeNavigation
import com.pablo.study.navigation.startNewActivity
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {
    private val nav: HomeNavigation by inject()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        startNewActivity(nav.getHomeIntent(this))
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}