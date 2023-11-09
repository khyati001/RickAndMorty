package com.example.rickandmorty.model

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)