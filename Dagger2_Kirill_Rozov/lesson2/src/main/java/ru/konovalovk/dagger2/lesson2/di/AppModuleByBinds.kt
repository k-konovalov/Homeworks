package ru.konovalovk.dagger2.lesson2.di

import dagger.Binds
import dagger.Module
import ru.konovalovk.dagger2.lesson2.MainActivity
import ru.konovalovk.dagger2.lesson2.data.Samsung
import ru.konovalovk.dagger2.lesson2.data.Store
import ru.konovalovk.dagger2.lesson2.data.StoreImpl
import ru.konovalovk.dagger2.lesson2.interfaces.SmartPhone

// ToDo: 1.3) Create module-interface with Binds (Binds / Provides)
@Module
interface AppModuleByBinds {
    @Binds
    fun bindSmartphone(samsung: Samsung): SmartPhone

    // ToDo: 2.5) Bind store (Injects)
    @Binds
    fun bindStore(storeImpl: StoreImpl): Store
}