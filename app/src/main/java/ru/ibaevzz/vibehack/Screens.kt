package ru.ibaevzz.vibehack

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.ibaevzz.vibehack.ui.check.CheckCodeFragment
import ru.ibaevzz.vibehack.ui.login.LoginFragment

object Screens {
    fun CheckCode(phone: String) = FragmentScreen {
        CheckCodeFragment.newInstance(phone)
    }
    fun Registration() = FragmentScreen { LoginFragment() }
    fun TasksFragment() = FragmentScreen { ru.ibaevzz.vibehack.ui.tasks.TasksFragment() }
    fun WardsFragment() = FragmentScreen { ru.ibaevzz.vibehack.ui.wards.WardsFragment() }
    fun FamilyFragment(id: Int) = FragmentScreen { ru.ibaevzz.vibehack.ui.family.FamilyFragment.newInstance(id) }
    fun VolonteerFragment() = FragmentScreen { ru.ibaevzz.vibehack.ui.volunteer.VolunteerFragment() }
}