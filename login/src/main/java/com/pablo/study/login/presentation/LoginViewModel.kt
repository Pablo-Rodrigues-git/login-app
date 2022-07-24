package com.pablo.study.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablo.study.login.data.repository.login.LoginModel
import com.pablo.study.login.data.repository.login.LoginRepository
import com.pablo.study.login.state.LoginResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository,
) : ViewModel() {

    private val _credentialsStateFlow =
        MutableStateFlow<LoginResourceState<Boolean>>(LoginResourceState.Empty())
    val credentialsStateFlow: StateFlow<LoginResourceState<Boolean>> = _credentialsStateFlow

    fun insert(loginModel: LoginModel) = viewModelScope.launch {
        _credentialsStateFlow.value = LoginResourceState.Loading()
        try {
            repository.saveLogin(loginModel)
            _credentialsStateFlow.value = LoginResourceState.Sucess(true)
        } catch (t: Throwable) {
            _credentialsStateFlow.value = LoginResourceState.Error("Erro de login")
        }
    }
}