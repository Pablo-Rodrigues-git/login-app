package com.pablo.study.register.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablo.study.register.data.repository.RegisterModel
import com.pablo.study.register.data.repository.RegisterRepository
import com.pablo.study.register.state.RegisterResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val repository: RegisterRepository,
) : ViewModel() {

    private val _registerStateFlow =
        MutableStateFlow<RegisterResourceState<Boolean>>(RegisterResourceState.Empty())
    val registerStateFlow: StateFlow<RegisterResourceState<Boolean>> = _registerStateFlow

    fun insert(registerModel: RegisterModel) = viewModelScope.launch {
        _registerStateFlow.value = RegisterResourceState.Loading()
        try {
            repository.saveCountry(registerModel)
            _registerStateFlow.value = RegisterResourceState.Sucess(true)
        } catch (t: Throwable) {
            _registerStateFlow.value = RegisterResourceState.Error("Erro ao Salvar País")
        }
    }
}