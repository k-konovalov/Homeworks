package ru.konovalovk.dagger2.lesson3.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.konovalovk.dagger2.lesson3.data.Computer
import javax.inject.Qualifier
import kotlin.random.Random

// ToDo: 2.2) Old way: add deps in to constructor
@Module
class AppModuleByProvides (private val context: Context) {
    @Provides
    fun provideComputer() = Computer("I am computer with num: ${Random.nextInt(0, 100)} and ${context.filesDir.absolutePath}")
}

@Module
class AppModuleByProvides2 {
    @SecondComputer
    @Provides
    fun provideComputer(context: Context) = Computer("I am computer with num: ${Random.nextInt(0, 100)} and ${context.filesDir.absolutePath}")
}

@Qualifier
annotation class SecondComputer