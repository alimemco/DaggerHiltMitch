package com.alirnp.daggerhiltmitch.ui.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.alirnp.daggerhiltmitch.ui.fragments.MainFragment
import javax.inject.Inject

class MainFragmentFactory
@Inject
constructor(private val company: String) :
    FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

       return when (className){
            MainFragment::class.java.name -> MainFragment(company)
            else -> super.instantiate(classLoader, className)
        }
    }
}