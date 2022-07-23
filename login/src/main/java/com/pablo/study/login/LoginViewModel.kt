package com.pablo.study.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablo.study.login.data.repository.LoginModel
import com.pablo.study.login.data.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository,
) : ViewModel() {
    fun insert(loginModel: LoginModel) = viewModelScope.launch {
        repository.saveLogin(loginModel)
    }
}