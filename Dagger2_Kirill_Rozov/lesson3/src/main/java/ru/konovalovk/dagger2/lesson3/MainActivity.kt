package ru.konovalovk.dagger2.lesson3

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.konovalovk.dagger2.lesson3.di.appComponent
import ru.konovalovk.dagger2.lesson3.interfaces.SmartPhone
import javax.inject.Inject
import dagger.Lazy
import ru.konovalovk.dagger2.lesson3.data.*
import ru.konovalovk.dagger2.lesson3.di.SmartPhoneStoreQualifier
import javax.inject.Named
import javax.inject.Provider

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    @Inject lateinit var computer: Computer
    @Inject lateinit var smartPhone: SmartPhone
    @Inject lateinit var store: Store
    @Inject lateinit var lazyStore: Lazy<Store>
    @Inject lateinit var providerStore: Provider<Store>
    @Inject lateinit var anotherStoreFactory: AnotherStoreImpl.Factory

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
        
        msg1 += appComponent.computer.text
        msg2 += appComponent.smartPhone.text
        
        msg1 += computer.text
        msg2 += smartPhone.text

        msg1 += store.computer.text
        msg2 += store.smartPhone.text

        val anotherStoreImpl = anotherStoreFactory.get(Display("I'm assisted display"))
        msg1 += anotherStoreImpl.display.text
        msg2 += anotherStoreImpl.smartPhone.text

        msg1 += computerStore.computer.text
        msg2 += smartphoneStore.smartPhone.text

        msg1 += lazyStore.get().computer.text
        msg1 += lazyStore.get().computer.text
        msg2 += providerStore.get().smartPhone.text
        msg2 += providerStore.get().smartPhone.text

        findViewById<TextView>(R.id.tv_hello).text = msg1
        findViewById<TextView>(R.id.tv_hello_2).text = msg2
    }

    @Inject
    fun init(notComputer: Computer){
        Log.i(javaClass.simpleName, "I'm injected with ${notComputer.text}")
    }
}