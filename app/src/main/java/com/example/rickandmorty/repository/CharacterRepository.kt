package com.example.rickandmorty.repository

import com.example.rickandmorty.model.CharacterResponse
import com.example.rickandmorty.retrofit.ApiService
import com.example.rickandmorty.retrofit.NetworkState
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCharacters(): NetworkState<CharacterResponse> {
        val response = apiService.getCharacters()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response.message())
            }
        } else {
            NetworkState.Error(response.message())
        }
    }
}