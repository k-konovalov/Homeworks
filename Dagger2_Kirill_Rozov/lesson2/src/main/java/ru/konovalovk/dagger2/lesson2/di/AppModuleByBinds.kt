package ru.konovalovk.dagger2.lesson2.di

import dagger.Binds
import dagger.Module
import ru.konovalovk.dagger2.lesson2.MainActivity
import ru.konovalovk.dagger2.lesson2.data.*
import ru.konovalovk.dagger2.lesson2.interfaces.SmartPhone
import javax.inject.Named
import javax.inject.Qualifier

// ToDo: 1.3) Create module-interface with Binds (Binds / Provides)
@Module
interface AppModuleByBinds {
    @Binds
    fun bindSmartphone(samsung: Samsung): SmartPhone

    // ToDo: 2.5) Bind store (Injects)
    // ToDo: 4.2) Add new stores to graph(Qualifier's)
    @Binds
    fun bindDefaultStore(storeImpl: DefaultStore): Store

    @Binds
    // ToDo: 4.3) Annotate with Named (Qualifier's)
    @Named("COMPUTER_STORE")
    fun bindComputerStore(computerStore: ComputerStore): Store

    @Binds
    // ToDo: 4.5) Annote with new qualifier (Qualifier's)
    @SmartPhoneStoreQualifier
    fun bindSmartphoneStore(smartPhoneStore: SmartPhoneStore): Store
}