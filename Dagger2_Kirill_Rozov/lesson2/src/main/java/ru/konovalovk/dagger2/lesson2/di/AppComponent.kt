package ru.konovalovk.dagger2.lesson2.di

import dagger.Component
import ru.konovalovk.dagger2.lesson2.MainActivity
import ru.konovalovk.dagger2.lesson2.data.Computer
import ru.konovalovk.dagger2.lesson2.data.Samsung
import ru.konovalovk.dagger2.lesson2.interfaces.SmartPhone

// ToDo: 1.4) Connect new module (Binds / Provides) and add new value
@Component(
    modules = [
        AppModuleByProvides::class,
        AppModuleByBinds::class
    ]
)
interface AppComponent {
    val computer: Computer
    val smartPhone: SmartPhone

    fun inject(mainActivity: MainActivity)
}