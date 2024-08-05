package ru.konovalovk.dagger2.lesson3.di.modules

import dagger.Binds
import dagger.Module
import ru.konovalovk.dagger2.lesson3.data.FragmentItem
import ru.konovalovk.dagger2.lesson3.data.SecondFragmentItem
import ru.konovalovk.dagger2.lesson3.di.scopes.SecondFragmentScope

@Module
interface SecondFragmentModule {
    @SecondFragmentScope
    @Binds
    fun bindSpecialSecondItem(secondFragmentItem: SecondFragmentItem): FragmentItem
}