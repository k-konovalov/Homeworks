package ru.konovalovk.dagger2.lesson3

import android.app.Application
import android.content.Context
import ru.konovalovk.dagger2.lesson3.di.*
import ru.konovalovk.dagger2.lesson3.interfaces.AppDeps
import ru.konovalovk.dagger2.lesson3.interfaces.StoreDeps

// ToDo: 3.4) Inherits from StoreDeps (1 way)
class MainApplication : Application(), StoreDeps {
    lateinit var appComponent: AppComponent
    override val context: Context = this@MainApplication

    override fun onCreate() {
        super.onCreate()
        // Codegen is the same as Builder
        // appComponent = DaggerAppComponent.create()
        // ToDo: 1.2) Create component with Builder
        appComponent = DaggerAppComponent.builder()
            // ToDo: 2.3) OldWay: Provide deps to module construct
            .appModuleByProvides(AppModuleByProvides(context = this))
            // ToDo: 3.6) Add interfaces-deps to component
            .appDeps(AppDepsImpl())
            .storeDeps(this)
            // ToDo: 2.5) Current way: Provide deps to component graph
            .context(context = this)
            .build()
    }

    // ToDo: 3.5) inner class of DepsImpl (2 way)
    inner class AppDepsImpl : AppDeps {
        @DefaultQualifier
        override val context: Context = this@MainApplication
    }
}

