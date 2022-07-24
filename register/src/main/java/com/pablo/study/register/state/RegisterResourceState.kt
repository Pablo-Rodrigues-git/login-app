package com.pablo.study.register.state

sealed class RegisterResourceState<T>(
    val data: T? = null,
    val message: String? = null,

    ) {
    class Sucess<T>(data: T) : RegisterResourceState<T>(data)
    class Error<T>(message: String?, data: T? = null) : RegisterResourceState<T>(data, message)
    class Loading<T> : RegisterResourceState<T>()
    class Empty<T> : RegisterResourceState<T>()
}