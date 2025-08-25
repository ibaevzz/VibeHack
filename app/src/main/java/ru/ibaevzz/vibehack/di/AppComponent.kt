package ru.ibaevzz.vibehack.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.ibaevzz.vibehack.ui.root.RootActivity
import ru.ibaevzz.vibehack.di.modules.*
import ru.ibaevzz.vibehack.di.annotations.UseMockApi
import ru.ibaevzz.vibehack.notification.NotificationHelper
import ru.ibaevzz.vibehack.ui.check.CheckCodeFragment
import ru.ibaevzz.vibehack.ui.login.LoginFragment
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

    fun provideNotificationHelper(): NotificationHelper

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance @UseMockApi useMock: Boolean
        ): AppComponent
    }

}