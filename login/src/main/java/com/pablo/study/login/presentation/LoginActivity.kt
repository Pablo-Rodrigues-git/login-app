package com.pablo.study.login.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pablo.study.login.data.repository.login.LoginModel
import com.pablo.study.login.databinding.ActivityLoginBinding
import com.pablo.study.login.state.LoginResourceState
import com.pablo.study.navigation.HomeNavigation
import com.pablo.study.navigation.RegisterNavigation
import com.pablo.study.navigation.startNewActivity
import com.pablo.study.navigation.startNewActivityAndFinish
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val navToHome: HomeNavigation by inject()
    private val navToRegister: RegisterNavigation by inject()
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observer()
        setupListeners()
    }

    private fun setupListeners() {
        val login = binding.login.editableText.toString()
        val password = binding.password.editableText.toString()
        binding.btnSave.setOnClickListener {
            viewModel.insert(
                LoginModel(
                    user = login,
                    password = password
                )
            )
        }
        binding.btnRegister.setOnClickListener {
            navigate()
        }
    }

    private fun navigate() {
        startNewActivityAndFinish(navToHome.getHomeIntent(this))
    }

    private fun observer() = lifecycleScope.launch {
        viewModel.credentialsStateFlow.collect { resource ->
            when (resource) {
                is LoginResourceState.Sucess -> {
                    resource.data?.let {
                        startNewActivity(navToHome.getHomeIntent(this@LoginActivity))
                    }
                }
                is LoginResourceState.Error -> {
                    Toast.makeText(this@LoginActivity, resource.message, Toast.LENGTH_SHORT)
                        .show()
                }
                else -> Unit
            }
        }
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
