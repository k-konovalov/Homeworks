package ru.konovalovk.dagger2.lesson3.data

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.konovalovk.dagger2.lesson3.interfaces.SmartPhone
import javax.inject.Inject

class DefaultStore @Inject constructor(
    override val computer: Computer,
    override val smartPhone: SmartPhone
) : Store

class AnotherStoreImpl @AssistedInject constructor(
    
    @Assisted("display") val display: Display,
    override val computer: Computer,
    override val smartPhone: SmartPhone,
): Store {

    @AssistedFactory
    interface Factory {
        fun get(@Assisted("display") display: Display): AnotherStoreImpl
    }
}

class SmartPhoneStore @Inject constructor(
    override val computer: Computer,
    override val smartPhone: SmartPhone) : Store

class ComputerStore @Inject constructor(
    override val computer: Computer,
    override val smartPhone: SmartPhone
) : Store

interface Store {
    val computer: Computer
    val smartPhone: SmartPhone
}