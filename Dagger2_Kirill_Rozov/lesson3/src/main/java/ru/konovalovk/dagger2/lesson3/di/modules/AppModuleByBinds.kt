package ru.konovalovk.dagger2.lesson3.di.modules

import dagger.Binds
import dagger.Module
import ru.konovalovk.dagger2.lesson3.data.*
import ru.konovalovk.dagger2.lesson3.di.SmartPhoneStoreQualifier
import ru.konovalovk.dagger2.lesson3.interfaces.SmartPhone
import javax.inject.Named
import javax.inject.Singleton

@Module
interface AppModuleByBinds {
    @Binds
    fun bindSmartphone(samsung: Samsung): SmartPhone

    @Binds
    @Named("COMPUTER_STORE")
    fun bindComputerStore(computerStore: ComputerStore): Store

    @Binds
    @SmartPhoneStoreQualifier
    fun bindSmartphoneStore(smartPhoneStore: SmartPhoneStore): Store
}