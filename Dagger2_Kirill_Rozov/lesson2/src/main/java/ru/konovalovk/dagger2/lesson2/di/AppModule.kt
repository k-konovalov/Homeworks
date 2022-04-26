package ru.konovalovk.dagger2.lesson2.di

import dagger.Module
import dagger.Provides
import ru.konovalovk.dagger2.lesson2.data.Computer

// ToDo: 2.2) Create @Module object
@Module
object AppModule {
    // ToDo: 3.2) Provides obj, that wants to be injected
    @Provides
    fun provideComputer() = Computer("Oh shit")
}