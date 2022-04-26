package ru.konovalovk.dagger2.lesson2.di

import dagger.Component
import ru.konovalovk.dagger2.lesson2.MainActivity
import ru.konovalovk.dagger2.lesson2.data.Computer

@Component(modules = [AppModule::class])
interface AppComponent {
    val computer: Computer
    fun inject(mainActivity: MainActivity)
}