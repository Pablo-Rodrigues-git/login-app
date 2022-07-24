package com.pablo.study.login.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pablo.study.login.LoginViewModel
import com.pablo.study.login.data.repository.login.LoginModel
import com.pablo.study.login.databinding.ActivityLoginBinding
import com.pablo.study.login.state.ResourceState
import com.pablo.study.navigation.HomeNavigation
import com.pablo.study.navigation.startNewActivity
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val nav: HomeNavigation by inject()
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observer()
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

    private fun observer() = lifecycleScope.launch {
        viewModel.credentialsStateFlow.collect { resource ->
            when (resource) {
                is ResourceState.Sucess -> {
                    resource.data?.let {
                        startNewActivity(nav.getHomeIntent(this@LoginActivity))
                    }
                }
                is ResourceState.Error -> {
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