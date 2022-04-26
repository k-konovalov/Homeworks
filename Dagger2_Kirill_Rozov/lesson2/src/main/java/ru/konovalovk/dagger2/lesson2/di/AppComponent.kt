package ru.konovalovk.dagger2.lesson2.di

import dagger.Component
import ru.konovalovk.dagger2.lesson2.MainActivity
import ru.konovalovk.dagger2.lesson2.data.Computer

// ToDo: 2.1) Create @Component interface
// ToDo: 2.3) Specify new module there
@Component(modules = [AppModule::class])
interface AppComponent {
    // ToDo: 2.4) Create val computer and fun, that inject component to activity
    val computer: Computer
    fun inject(mainActivity: MainActivity)
}