package ru.ibaevzz.vibehack.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.ibaevzz.vibehack.di.annotations.ViewModelKey
import ru.ibaevzz.vibehack.ui.ViewModelFactory
import ru.ibaevzz.vibehack.ui.check.CheckCodeViewModel
import ru.ibaevzz.vibehack.ui.family.FamilyViewModel
import ru.ibaevzz.vibehack.ui.login.LoginViewModel
import ru.ibaevzz.vibehack.ui.root.RootViewModel
import ru.ibaevzz.vibehack.ui.tasks.TasksViewModel
import ru.ibaevzz.vibehack.ui.volunteer.VolunteerViewModel
import ru.ibaevzz.vibehack.ui.wards.WardsViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(vm: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RootViewModel::class)
    abstract fun bindRootViewModel(vm: RootViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CheckCodeViewModel::class)
    abstract fun bindCheckViewModel(vm: CheckCodeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FamilyViewModel::class)
    abstract fun bindFamilyViewModel(vm: FamilyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TasksViewModel::class)
    abstract fun bindTasksViewModel(vm: TasksViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WardsViewModel::class)
    abstract fun bindWardsViewModel(vm: WardsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(VolunteerViewModel::class)
    abstract fun bindVolunteerViewModel(vm: VolunteerViewModel): ViewModel

}