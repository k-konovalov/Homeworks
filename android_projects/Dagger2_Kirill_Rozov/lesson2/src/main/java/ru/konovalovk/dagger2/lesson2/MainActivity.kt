package ru.konovalovk.dagger2.lesson2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.konovalovk.dagger2.lesson2.di.appComponent
import ru.konovalovk.dagger2.lesson2.interfaces.SmartPhone
import javax.inject.Inject
import dagger.Lazy
import ru.konovalovk.dagger2.lesson2.data.*
import ru.konovalovk.dagger2.lesson2.di.SmartPhoneStoreQualifier
import javax.inject.Named
import javax.inject.Provider

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    // ToDo: 2.1) Inject into variable (Injects)
    @Inject lateinit var computer: Computer
    @Inject lateinit var smartPhone: SmartPhone
    @Inject lateinit var store: Store
    // ToDo: 5.1) Make store Lazy
    // ToDo: 5.2) Make .. Provider
    @Inject lateinit var lazyStore: Lazy<Store>
    @Inject lateinit var providerStore: Provider<Store>
    // ToDo: 3.7) Inject Class Factory (Assisted Inject)
    @Inject lateinit var anotherStoreFactory: AnotherStoreImpl.Factory

    // ToDo: 4.6) Inject and annotate witn Named and Custom Qualidiers(Qualifier's)
    @Inject @Named("COMPUTER_STORE") lateinit var computerStore: Store
    @Inject @SmartPhoneStoreQualifier lateinit var smartphoneStore: Store

    private var msg1 = ""
        set(value) {
            field = "$value\n"
        }
    private var msg2 = ""
        set(value) {
            field = "$value\n"
        }

    init {
        Log.i(javaClass.simpleName, "I'm inited")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        // ToDo: 1.5) Uses new object (Binds / Provides)
        msg1 += appComponent.computer.text
        msg2 += appComponent.smartPhone.text

        // ToDo: 2.2) Uses inject with variable (Injects)
        msg1 += computer.text
        msg2 += smartPhone.text

        // ToDo: 2.5) Uses inject with constructor (Injects)
        msg1 += store.computer.text
        msg2 += store.smartPhone.text

        // ToDo: 3.8) Provide lost param to object and get impl with injected obj (Assisted Inject)
        val anotherStoreImpl = anotherStoreFactory.get(Display("I'm assisted display"))
        msg1 += anotherStoreImpl.display.text
        msg2 += anotherStoreImpl.smartPhone.text

        // ToDo: 4.7) Uses new stores (Qualifier's)
        msg1 += computerStore.computer.text
        msg2 += smartphoneStore.smartPhone.text

        // ToDo: 5.3) Uses Lazy & Provider
        msg1 += lazyStore.get().computer.text
        msg1 += lazyStore.get().computer.text
        msg2 += providerStore.get().smartPhone.text
        msg2 += providerStore.get().smartPhone.text

        findViewById<TextView>(R.id.tv_hello).text = msg1
        findViewById<TextView>(R.id.tv_hello_2).text = msg2
    }

    // ToDo: 2.3) Inject into method (Injects)
    @Inject
    fun init(notComputer: Computer){
        Log.i(javaClass.simpleName, "I'm injected with ${notComputer.text}")
    }
}