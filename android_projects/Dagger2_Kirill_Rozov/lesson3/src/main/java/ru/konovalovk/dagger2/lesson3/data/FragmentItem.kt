package ru.konovalovk.dagger2.lesson3.data

data class FirstFragmentItem (override val text: String = "FirstItem") : FragmentItem {
    override fun overrideHashCode() = "$text: ${hashCode()}"
}

data class SecondFragmentItem (override val text: String = "SecondItem") : FragmentItem {
    override fun overrideHashCode() = "$text: ${hashCode()}"
}

interface FragmentItem {
    val text: String
    fun overrideHashCode(): String
}