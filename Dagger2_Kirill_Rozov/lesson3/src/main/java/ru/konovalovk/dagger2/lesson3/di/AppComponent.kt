package ru.konovalovk.dagger2.lesson3.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.konovalovk.dagger2.lesson3.MainActivity
import ru.konovalovk.dagger2.lesson3.data.Computer
import ru.konovalovk.dagger2.lesson3.interfaces.AppDeps
import ru.konovalovk.dagger2.lesson3.interfaces.SmartPhone
import ru.konovalovk.dagger2.lesson3.interfaces.StoreDeps

@Component(
    modules = [
        AppModuleByProvides::class,
        AppModuleByProvides2::class,
        AppModuleByBinds::class
    ],
    // ToDo: 3.2) Add it as dependencies
    dependencies = [
        AppDeps::class,
        StoreDeps::class
    ]
)
interface AppComponent {
    val computer: Computer
    val smartPhone: SmartPhone

    fun inject(mainActivity: MainActivity)

    // ToDo: 1.1) Create Builder with fun build
    @Component.Builder
    interface Builder {
        // ToDo: 2.1) Old way: to provide object-deps to component module
        fun appModuleByProvides(AppModuleByProvides: AppModuleByProvides): Builder

        // ToDo: 3.3) Add it to Builder
        fun appDeps(appDeps: AppDeps): Builder
        fun storeDeps(storeDeps: StoreDeps): Builder

        // ToDo: 2.4) Current way: to provide object-deps to component graph
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}