package ru.konovalovk.dagger2.lesson2.data

import ru.konovalovk.dagger2.lesson2.interfaces.SmartPhone
import javax.inject.Inject
import kotlin.random.Random

// ToDo: 1.2) Create Impl (Binds / Provides)
class Samsung @Inject constructor(): SmartPhone {
    override val text: String = "I am smartphone with num: ${Random.nextInt(0, 100)}"
}