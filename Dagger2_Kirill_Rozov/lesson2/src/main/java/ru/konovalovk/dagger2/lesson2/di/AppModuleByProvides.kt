package ru.konovalovk.dagger2.lesson2.di

import dagger.Module
import dagger.Provides
import ru.konovalovk.dagger2.lesson2.data.Computer

@Module
object AppModuleByProvides {
    @Provides
    fun provideComputer() = Computer("I am computer")
}