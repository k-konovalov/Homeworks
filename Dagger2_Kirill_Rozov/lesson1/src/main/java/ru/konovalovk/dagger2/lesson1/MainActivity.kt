package ru.konovalovk.dagger2.lesson1

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ru.konovalovk.dagger2.lesson1.data.Computer
import ru.konovalovk.dagger2.lesson1.di.appComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    // ToDo: 3.5) Inject object from DI graph
    @Inject lateinit var computer: Computer

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        // ToDo: 3.4) Inject AppComponent to Activity
        appComponent.inject(this)
    }
}