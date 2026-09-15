package ru.konovalovk.dagger2.lesson3.di.components

import androidx.lifecycle.ViewModel
import dagger.Component
import ru.konovalovk.dagger2.lesson3.data.SecondFragmentItem
import ru.konovalovk.dagger2.lesson3.di.modules.AppModuleByProvides
import ru.konovalovk.dagger2.lesson3.di.modules.SecondFragmentModule
import ru.konovalovk.dagger2.lesson3.di.scopes.SecondFragmentScope
import ru.konovalovk.dagger2.lesson3.ui.SecondFragment

@Component(modules = [SecondFragmentModule::class])
@SecondFragmentScope
interface SecondFragmentComponent {
    fun inject(viewModel: SecondFragment)
}