package ru.konovalovk.dagger2.lesson3

import android.app.Application
import ru.konovalovk.dagger2.lesson3.di.AppComponent
import ru.konovalovk.dagger2.lesson3.di.AppModuleByProvides
import ru.konovalovk.dagger2.lesson3.di.DaggerAppComponent

class MainApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // Codegen is the same as Builder
        // appComponent = DaggerAppComponent.create()
        // ToDo: 1.2) Create component with Builder
        appComponent = DaggerAppComponent.builder()
            // ToDo: 2.3) OldWay: Provide deps to module construct
            .appModuleByProvides(AppModuleByProvides(context = this))
            // ToDo: 2.5) Current way: Provide deps to component graph
            .context(context = this)
            .build()
    }
}