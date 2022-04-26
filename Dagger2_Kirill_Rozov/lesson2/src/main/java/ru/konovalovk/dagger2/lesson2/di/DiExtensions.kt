package ru.konovalovk.dagger2.lesson2.di

import android.content.Context
import ru.konovalovk.dagger2.lesson2.MainApplication

//ToDo: 3.3) Add Context extension that finds AppComponent recursively
val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApplication -> appComponent
        else -> this.applicationContext.appComponent
    }