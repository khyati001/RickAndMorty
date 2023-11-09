package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.di.ApplicationComponent
import com.example.rickandmorty.di.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}