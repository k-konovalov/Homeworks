package ru.konovalovk.dagger2.lesson2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.konovalovk.dagger2.lesson2.data.Computer
import ru.konovalovk.dagger2.lesson2.di.appComponent
import ru.konovalovk.dagger2.lesson2.interfaces.SmartPhone
import javax.inject.Inject
import dagger.Lazy
import ru.konovalovk.dagger2.lesson2.data.Store

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    // ToDo: 2.1) Inject into variable (Injects)
    @Inject lateinit var computer: Computer
    @Inject lateinit var smartPhone: SmartPhone
    @Inject lateinit var store: Lazy<Store>

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
    }

    // ToDo: 2.3) Inject into method (Injects)
    @Inject
    fun init(notComputer: Computer){
        Log.i(javaClass.simpleName, "I'm injected with ${notComputer.text}")
    }
}