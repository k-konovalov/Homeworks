package ru.konovalovk.dagger2.lesson3.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.konovalovk.dagger2.lesson3.data.FirstFragmentItem
import ru.konovalovk.dagger2.lesson3.data.FragmentItem
import ru.konovalovk.dagger2.lesson3.di.scopes.FirstFragmentScope

@Module
interface FirstFragmentModule {
    @FirstFragmentScope
    @Binds
    fun bindSpecialFirstItem(firstFragmentItem: FirstFragmentItem): FragmentItem
}