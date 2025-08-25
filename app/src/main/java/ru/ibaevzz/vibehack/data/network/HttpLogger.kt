package ru.ibaevzz.vibehack.data.network

import okhttp3.logging.HttpLoggingInterceptor

class HttpLogger : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
        android.util.Log.d(TAG, message)
    }

    companion object {
        private val TAG = HttpLogger::class.simpleName
    }

}