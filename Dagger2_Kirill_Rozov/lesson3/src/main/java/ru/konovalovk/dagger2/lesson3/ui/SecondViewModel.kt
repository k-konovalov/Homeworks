package ru.konovalovk.dagger2.lesson3.ui

import androidx.lifecycle.ViewModel
import ru.konovalovk.dagger2.lesson3.di.components.DaggerSecondFragmentComponent
import ru.konovalovk.dagger2.lesson3.di.components.SecondFragmentComponent

class SecondViewModel : ViewModel() {
    val daggerComponent: SecondFragmentComponent = DaggerSecondFragmentComponent.create()
}