package ru.konovalovk.dagger2.lesson2.di

import javax.inject.Qualifier

// ToDo: 4.4) Create new annotation class andd annotate with @Qualifier(Qualifier's)
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SmartPhoneStoreQualifier