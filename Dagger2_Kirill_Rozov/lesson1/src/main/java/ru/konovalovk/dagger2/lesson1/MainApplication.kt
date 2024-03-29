package ru.konovalovk.dagger2.lesson1

import android.app.Application
import ru.konovalovk.dagger2.lesson1.di.AppComponent
import ru.konovalovk.dagger2.lesson1.di.DaggerAppComponent

// ToDo: 2.5) Create MainApplication and create new Dagger2 Component
class MainApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}