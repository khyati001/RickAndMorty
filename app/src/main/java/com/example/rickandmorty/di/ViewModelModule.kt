package com.example.rickandmorty.di

import androidx.lifecycle.ViewModel
import com.example.rickandmorty.viewmodel.CharacterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(CharacterViewModel::class)
    @IntoMap
    abstract fun characterViewModel(
        characterViewModel: CharacterViewModel
    ): ViewModel
}