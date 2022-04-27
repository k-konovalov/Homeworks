package ru.konovalovk.dagger2.lesson2.data

import ru.konovalovk.dagger2.lesson2.interfaces.SmartPhone
import javax.inject.Inject

// ToDo: 2.4) Inject into constructor (Injects)
class StoreImpl @Inject constructor(
    override val computer: Computer,
    override val smartPhone: SmartPhone
): Store

interface Store {
    val computer: Computer
    val smartPhone: SmartPhone
}