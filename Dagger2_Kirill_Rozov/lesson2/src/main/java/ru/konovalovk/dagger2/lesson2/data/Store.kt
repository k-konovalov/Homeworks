package ru.konovalovk.dagger2.lesson2.data

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.konovalovk.dagger2.lesson2.interfaces.SmartPhone
import javax.inject.Inject

// ToDo: 2.4) Inject into constructor (Injects)
class DefaultStore @Inject constructor(
    override val computer: Computer,
    override val smartPhone: SmartPhone
) : Store

// ToDo: 3.2) Change @Inject to @AssistedInject (Assisted Inject)
class AnotherStoreImpl @AssistedInject constructor(
    //ToDo: 3.3) Annotate with id, often variable name (Assisted Inject)
    @Assisted("display") val display: Display,
    override val computer: Computer,
    override val smartPhone: SmartPhone,
): Store {

    // ToDo: 3.4) Create Factory with @AssistedFactory annotation (Assisted Inject)
    @AssistedFactory
    interface Factory {
        // ToDo: 3.5) Create fun, where one of the param not in Graph
        // ToDo: 3.6) Annotate this param with previously id) and return parent class
        fun get(@Assisted("display") display: Display): AnotherStoreImpl
    }
}

// ToDo: 4.1) Create new stores (Qualifier's)
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