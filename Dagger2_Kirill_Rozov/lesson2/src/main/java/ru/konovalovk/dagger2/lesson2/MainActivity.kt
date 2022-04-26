package ru.konovalovk.dagger2.lesson2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.konovalovk.dagger2.lesson2.di.appComponent

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        findViewById<TextView>(R.id.tv_hello).text = appComponent.computer.text
        // ToDo: 1.5) Uses new object (Binds / Provides)
        findViewById<TextView>(R.id.tv_hello_2).text = appComponent.samsung.text
    }
}