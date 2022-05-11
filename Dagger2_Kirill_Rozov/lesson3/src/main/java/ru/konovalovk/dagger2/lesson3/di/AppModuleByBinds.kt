package ru.konovalovk.dagger2.lesson3.di

import dagger.Binds
import dagger.Module
import ru.konovalovk.dagger2.lesson3.MainActivity
import ru.konovalovk.dagger2.lesson3.data.*
import ru.konovalovk.dagger2.lesson3.interfaces.SmartPhone
import javax.inject.Named
import javax.inject.Qualifier

@Module
interface AppModuleByBinds {
    @Binds
    fun bindSmartphone(samsung: Samsung): SmartPhone

    @Binds
    fun bindDefaultStore(storeImpl: DefaultStore): Store

    @Binds
    @Named("COMPUTER_STORE")
    fun bindComputerStore(computerStore: ComputerStore): Store

    @Binds
    @SmartPhoneStoreQualifier
    fun bindSmartphoneStore(smartPhoneStore: SmartPhoneStore): Store
}