package ru.ibaevzz.vibehack

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.ibaevzz.vibehack.ui.check.CheckCodeFragment
import ru.ibaevzz.vibehack.ui.login.LoginFragment

object Screens {
    fun CheckCode(phone: String) = FragmentScreen {
        CheckCodeFragment.newInstance(phone)
    }
    fun Registration() = FragmentScreen { LoginFragment() }
}