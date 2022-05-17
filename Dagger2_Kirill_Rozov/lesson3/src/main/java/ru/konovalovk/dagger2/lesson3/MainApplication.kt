package ru.konovalovk.dagger2.lesson3

import android.app.Application
import ru.konovalovk.dagger2.lesson3.di.AppComponent
import ru.konovalovk.dagger2.lesson3.di.DaggerAppComponent

class MainApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // Codegen is the same as Builder
        appComponent = DaggerAppComponent.create()
        // ToDo: 1.2) Create component with Builder
        appComponent = DaggerAppComponent.builder()
            .build()
    }
}