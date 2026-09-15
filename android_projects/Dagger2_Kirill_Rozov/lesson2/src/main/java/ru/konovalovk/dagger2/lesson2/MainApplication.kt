package ru.konovalovk.dagger2.lesson2

import android.app.Application
import ru.konovalovk.dagger2.lesson2.di.AppComponent
import ru.konovalovk.dagger2.lesson2.di.DaggerAppComponent

class MainApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}