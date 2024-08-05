package ru.konovalovk.dagger2.lesson3.di.components

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.Component
import ru.konovalovk.dagger2.lesson3.di.modules.FirstFragmentModule
import ru.konovalovk.dagger2.lesson3.di.scopes.FirstFragmentScope
import ru.konovalovk.dagger2.lesson3.ui.FirstFragment

@Component(modules = [FirstFragmentModule::class])
@FirstFragmentScope
interface FirstFragmentComponent {
    fun inject(firstFragment: FirstFragment)
}