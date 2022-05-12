package ru.konovalovk.dagger2.lesson3.di

import dagger.Module
import dagger.Provides
import ru.konovalovk.dagger2.lesson3.data.Computer
import kotlin.random.Random

@Module
object AppModuleByProvides {
    @Provides
    fun provideComputer() = Computer("I am computer with num: ${Random.nextInt(0, 100)}")
}