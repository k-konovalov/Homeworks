package ru.konovalovk.dagger2.lesson3.data

import ru.konovalovk.dagger2.lesson3.interfaces.SmartPhone
import javax.inject.Inject
import kotlin.random.Random

class Samsung @Inject constructor(): SmartPhone {
    override val text: String = "I am smartphone with num: ${Random.nextInt(0, 100)}"
}