package com.example.rickandmorty.retrofit

sealed class NetworkState<out T> {
    data class Success<out T>(val data: T) : NetworkState<T>()
    data class Error<T>(val errorMessage: String) : NetworkState<T>()
}