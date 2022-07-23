package com.pablo.study.login.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.pablo.study.login.LoginViewModel
import com.pablo.study.login.data.repository.LoginModel
import com.pablo.study.login.databinding.ActivityLoginBinding
import com.pablo.study.navigation.HomeNavigation
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity() {
    private val nav: HomeNavigation by inject()
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        startNewActivity(nav.getHomeIntent(this))

        setupListeners()
    }

    private fun setupListeners() = binding.apply {
        val login = login.text.toString()
        val password = password.text.toString()

        btnSave.setOnClickListener {
            viewModel.insert(
                LoginModel(
                    user = login,
                    password = password
                )
            )
        }
    }


    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}