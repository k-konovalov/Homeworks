package ru.konovalovk.dagger2.lesson3.ui

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {
    open var daggerComponent: T? = null

    override fun onCleared() {
        daggerComponent = null
        super.onCleared()
    }
}