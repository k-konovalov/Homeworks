package ru.konovalovk.dagger2.lesson3.ui

import dagger.Lazy
import ru.konovalovk.dagger2.lesson3.data.FirstFragmentItem
import ru.konovalovk.dagger2.lesson3.data.FragmentItem
import ru.konovalovk.dagger2.lesson3.di.components.DaggerFirstFragmentComponent
import ru.konovalovk.dagger2.lesson3.di.components.FirstFragmentComponent
import javax.inject.Inject

class FirstViewModel : BaseViewModel<FirstFragmentComponent>() {
    init {
        daggerComponent = DaggerFirstFragmentComponent.create()
    }
}