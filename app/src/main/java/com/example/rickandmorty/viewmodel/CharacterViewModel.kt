package com.example.rickandmorty.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.repository.CharacterRepository
import com.example.rickandmorty.retrofit.NetworkState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    val characters = MutableLiveData<List<Character>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        isLoading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = characterRepository.getCharacters()) {
                is NetworkState.Success -> {
                    characters.postValue(response.data.results)
                    isLoading.postValue(false)
                }

                is NetworkState.Error -> {
                    Log.e("Error", response.errorMessage)
                    isLoading.postValue(false)
                }
            }
        }
    }
}