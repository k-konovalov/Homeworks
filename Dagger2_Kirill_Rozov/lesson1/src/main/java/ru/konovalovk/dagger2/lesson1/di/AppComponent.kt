package ru.konovalovk.dagger2.lesson1.di

import dagger.Component
import ru.konovalovk.dagger2.lesson1.MainActivity

// ToDo: 2.1) Create @Component interface
// ToDo: 2.3) Specify new module there
@Component(modules = [AppModule::class])
interface AppComponent {
    // ToDo: 2.4) Create fun, that inject component to activity
    fun inject(mainActivity: MainActivity)
}