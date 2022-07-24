package com.pablo.study.login.state

sealed class LoginResourceState<T>(
    val data: T? = null,
    val message: String? = null,

    ) {
    class Sucess<T>(data: T) : LoginResourceState<T>(data)
    class Error<T>(message: String?, data: T? = null) : LoginResourceState<T>(data, message)
    class Loading<T> : LoginResourceState<T>()
    class Empty<T> : LoginResourceState<T>()
}