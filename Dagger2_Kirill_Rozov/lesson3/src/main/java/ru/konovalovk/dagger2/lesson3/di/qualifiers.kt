package ru.konovalovk.dagger2.lesson3.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SmartPhoneStoreQualifier

@Qualifier
annotation class StoreQualifier

@Qualifier
annotation class DefaultQualifier