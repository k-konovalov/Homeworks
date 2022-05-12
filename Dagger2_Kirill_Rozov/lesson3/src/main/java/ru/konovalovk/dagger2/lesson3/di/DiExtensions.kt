package ru.konovalovk.dagger2.lesson3.di

import android.content.Context
import ru.konovalovk.dagger2.lesson3.MainApplication

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApplication -> appComponent
        else -> this.applicationContext.appComponent
    }