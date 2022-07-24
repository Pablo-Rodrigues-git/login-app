package com.pablo.study.register.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pablo.study.navigation.RegisterNavigation
import com.pablo.study.navigation.startNewActivity
import com.pablo.study.navigation.startNewActivityAndFinish
import com.pablo.study.register.data.repository.RegisterModel
import com.pablo.study.register.databinding.SignInBinding
import com.pablo.study.register.state.RegisterResourceState
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {
    private val nav: RegisterNavigation by inject()
    private lateinit var binding: SignInBinding
    private val viewModel: RegisterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignInBinding.inflate(layoutInflater)
        observer()
        setupListeners()
    }

    private fun setupListeners() {
        val email = binding.login.text.toString()
        val password = binding.password.text.toString()
        binding.btnSave.setOnClickListener {
            validateInputs()
            comparePasswords()
            viewModel.insert(
                RegisterModel(
                    email = email,
                    password = password,
                )
            )
        }
    }

    private fun validateInputs() {
        val login = binding.login

        when {
            TextUtils.isEmpty(binding.login.text.toString().trim()) -> {
                login.setError("Por favor Insira seu E-mail")
            }
            TextUtils.isEmpty(binding.password.text.toString().trim()) -> {
                login.setError("Por favor Insira sua senha")
            }
        }
    }

    private fun comparePasswords() {
        val login = binding.login
        val password = binding.password
        val cnfPassword = binding.cnfPassword
        if (login.text.toString().isNotEmpty() &&
            password.text.toString().isNotEmpty()
        ) {
            if (login.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))) {
                if (password.text.toString().length >= 5) {

                    if (password.text.toString() == cnfPassword.text.toString()) {
                        Toast.makeText(this@RegisterActivity,
                            "Cadastro Realizado com Sucesso!",
                            Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@RegisterActivity,
                            "As senhas não conferem!",
                            Toast.LENGTH_SHORT).show()
                    }

                } else {
                    password.setError("Por favor Insira uma senha com pelo menos 5 caracteres")
                }
            }
        }
    }

    private fun observer() = lifecycleScope.launch {
        viewModel.registerStateFlow.collect { resource ->
            when (resource) {
                is RegisterResourceState.Sucess -> {
                    resource.data?.let {
                        startNewActivity(nav.getRegisterIntent(this@RegisterActivity))
                    }
                }
                is RegisterResourceState.Error -> {
                    Toast.makeText(this@RegisterActivity, resource.message, Toast.LENGTH_SHORT)
                        .show()
                }
                else -> Unit
            }
        }

    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }
}