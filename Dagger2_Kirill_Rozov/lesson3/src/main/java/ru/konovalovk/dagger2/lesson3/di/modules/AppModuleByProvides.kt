package ru.konovalovk.dagger2.lesson3.di.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.konovalovk.dagger2.lesson3.data.Computer
import ru.konovalovk.dagger2.lesson3.data.DefaultStore
import ru.konovalovk.dagger2.lesson3.data.Store
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.random.Random

// ToDo: 2.2) Old way: add deps in to constructor
@Module
class AppModuleByProvides (private val context: Context) {
    @Singleton
    @Provides
    fun provideDefaultStore(storeImpl: DefaultStore): Store = DefaultStore(storeImpl.computer, storeImpl.smartPhone)

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