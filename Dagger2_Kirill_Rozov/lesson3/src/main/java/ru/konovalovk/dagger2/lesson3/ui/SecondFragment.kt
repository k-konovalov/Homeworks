package ru.konovalovk.dagger2.lesson3.ui

import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.Lazy
import ru.konovalovk.dagger2.lesson3.R
import ru.konovalovk.dagger2.lesson3.data.FragmentItem
import javax.inject.Inject

class SecondFragment : Fragment(R.layout.second_fragment) {
    private val viewModel: SecondViewModel by viewModels()

    @Inject
    lateinit var secondFragmentItem: Lazy<FragmentItem>

    override fun onStart() {
        super.onStart()
        viewModel.daggerComponent?.inject(this)
        requireView().findViewById<TextView>(R.id.tv_hello).text = secondFragmentItem.get().overrideHashCode()
    }
}