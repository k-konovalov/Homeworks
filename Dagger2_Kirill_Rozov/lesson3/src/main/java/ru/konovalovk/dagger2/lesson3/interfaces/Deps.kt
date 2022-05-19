package ru.konovalovk.dagger2.lesson3.interfaces

import android.content.Context

// ToDo: 3.1) Create two different interfaces for deps
interface StoreDeps {
    val context: Context
}

interface AppDeps {
    val context: Context
}