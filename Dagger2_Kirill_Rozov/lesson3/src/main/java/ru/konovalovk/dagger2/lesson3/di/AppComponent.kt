package ru.konovalovk.dagger2.lesson3.di

import dagger.Component
import ru.konovalovk.dagger2.lesson3.MainActivity
import ru.konovalovk.dagger2.lesson3.data.Computer
import ru.konovalovk.dagger2.lesson3.data.Samsung
import ru.konovalovk.dagger2.lesson3.interfaces.SmartPhone

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