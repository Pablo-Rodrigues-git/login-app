package com.pablo.study.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablo.study.login.data.repository.LoginModel
import com.pablo.study.login.data.repository.LoginRepository
import com.pablo.study.login.state.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository,
) : ViewModel() {

    private val _credentialsStateFlow =
        MutableStateFlow<ResourceState<Boolean>>(ResourceState.Empty())
    val credentialsStateFlow: StateFlow<ResourceState<Boolean>> = _credentialsStateFlow

    fun insert(loginModel: LoginModel) = viewModelScope.launch {
        _credentialsStateFlow.value = ResourceState.Loading()
        try {
            repository.saveLogin(loginModel)
            _credentialsStateFlow.value = ResourceState.Sucess(true)
        } catch (t: Throwable) {
            _credentialsStateFlow.value = ResourceState.Error("Erro de login")
        }
    }
}