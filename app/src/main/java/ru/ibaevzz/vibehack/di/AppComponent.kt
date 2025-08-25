package ru.ibaevzz.vibehack.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.ibaevzz.vibehack.ui.root.RootActivity
import ru.ibaevzz.vibehack.di.modules.*
import ru.ibaevzz.vibehack.di.annotations.UseMockApi
import ru.ibaevzz.vibehack.notification.NotificationHelper
import ru.ibaevzz.vibehack.ui.check.CheckCodeFragment
import ru.ibaevzz.vibehack.ui.family.FamilyFragment
import ru.ibaevzz.vibehack.ui.login.LoginFragment
import ru.ibaevzz.vibehack.ui.tasks.TasksFragment
import ru.ibaevzz.vibehack.ui.volunteer.VolunteerFragment
import ru.ibaevzz.vibehack.ui.wards.WardsFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    RepoModule::class,
    ViewModelModule::class
])
interface AppComponent {

    fun inject(activity: RootActivity)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: CheckCodeFragment)
    fun inject(fragment: TasksFragment)
    fun inject(fragment: FamilyFragment)
    fun inject(fragment: WardsFragment)
    fun inject(fragment: VolunteerFragment)

    fun provideNotificationHelper(): NotificationHelper

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance @UseMockApi useMock: Boolean
        ): AppComponent
    }

}