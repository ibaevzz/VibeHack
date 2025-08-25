package ru.ibaevzz.vibehack

import android.app.Application
import ru.ibaevzz.vibehack.di.AppComponent
import ru.ibaevzz.vibehack.di.DaggerAppComponent
import ru.ibaevzz.vibehack.utils.USE_MOCK_API

class App : Application() {

    lateinit var appComponent: AppComponent private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory()
            .create(this, USE_MOCK_API)
    }
}