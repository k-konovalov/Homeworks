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
import ru.konovalovk.dagger2.lesson2.di.AppModuleByBinds
import ru.konovalovk.dagger2.lesson2.di.SmartPhoneStoreQualifier
import javax.inject.Named

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    // ToDo: 2.1) Inject into variable (Injects)
    @Inject lateinit var computer: Computer
    @Inject lateinit var smartPhone: SmartPhone
    @Inject lateinit var store: Lazy<Store>
    // ToDo: 3.7) Inject Class Factory (Assisted Inject)
    @Inject lateinit var anotherStoreFactory: AnotherStoreImpl.Factory

    // ToDo: 4.6) Inject and annotate witn Named and Custom Qualidiers(Qualifier's)
    @Inject @Named("COMPUTER_STORE") lateinit var computerStore: Store
    @Inject @SmartPhoneStoreQualifier lateinit var smartphoneStore: Store

    init {
        Log.i(javaClass.simpleName, "I'm inited")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        // ToDo: 1.5) Uses new object (Binds / Provides)
        findViewById<TextView>(R.id.tv_hello).text = appComponent.computer.text
        findViewById<TextView>(R.id.tv_hello_2).text = appComponent.smartPhone.text

        // ToDo: 2.2) Uses inject with variable (Injects)
        findViewById<TextView>(R.id.tv_hello).text = computer.text
        findViewById<TextView>(R.id.tv_hello_2).text = smartPhone.text

        // ToDo: 2.5) Uses inject with constructor (Injects)
        findViewById<TextView>(R.id.tv_hello).text = store.get().computer.text
        findViewById<TextView>(R.id.tv_hello_2).text = store.get().smartPhone.text

        // ToDo: 3.8) Provide lost param to object and get impl with injected obj (Assisted Inject)
        val anotherStoreImpl = anotherStoreFactory.get(Display("I'm assisted display"))
        findViewById<TextView>(R.id.tv_hello).text = anotherStoreImpl.display.text
        findViewById<TextView>(R.id.tv_hello_2).text = anotherStoreImpl.smartPhone.text

        // ToDo: 4.7) Uses new stores (Qualifier's)
        findViewById<TextView>(R.id.tv_hello).text = computerStore.computer.text
        findViewById<TextView>(R.id.tv_hello_2).text = smartphoneStore.smartPhone.text
    }

    // ToDo: 2.3) Inject into method (Injects)
    @Inject
    fun init(notComputer: Computer){
        Log.i(javaClass.simpleName, "I'm injected with ${notComputer.text}")
    }
}