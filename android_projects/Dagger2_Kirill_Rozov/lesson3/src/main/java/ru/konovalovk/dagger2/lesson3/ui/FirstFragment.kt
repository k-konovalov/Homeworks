package ru.konovalovk.dagger2.lesson3.ui

import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.Lazy
import ru.konovalovk.dagger2.lesson3.R
import ru.konovalovk.dagger2.lesson3.data.FragmentItem
import javax.inject.Inject

class FirstFragment : Fragment(R.layout.first_fragment) {
    private val viewModel: FirstViewModel by viewModels()

    @Inject
    lateinit var firstFragmentItem: Lazy<FragmentItem>

    override fun onStart() {
        super.onStart()
        viewModel.daggerComponent?.inject(this)
        requireView().findViewById<TextView>(R.id.tv_hello).text = firstFragmentItem.get().overrideHashCode()
    }
}