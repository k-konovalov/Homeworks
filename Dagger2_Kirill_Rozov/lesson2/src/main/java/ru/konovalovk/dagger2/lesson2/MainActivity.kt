package ru.konovalovk.dagger2.lesson2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.konovalovk.dagger2.lesson2.di.appComponent

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    // ToDo: 3.5) Inject object from DI graph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ToDo: 3.4) Inject AppComponent to Activity
        appComponent.inject(this)
        // ToDo: 3.5) Get computer from appComponent directly
        findViewById<TextView>(R.id.tv_hello).text = appComponent.computer.test
    }
}