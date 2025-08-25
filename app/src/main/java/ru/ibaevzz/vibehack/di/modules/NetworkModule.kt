package ru.ibaevzz.vibehack.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ibaevzz.vibehack.data.network.AuthInterceptor
import ru.ibaevzz.vibehack.data.network.HttpLogger
import ru.ibaevzz.vibehack.data.network.api.MockUserApi
import ru.ibaevzz.vibehack.data.network.api.UserApi
import ru.ibaevzz.vibehack.di.annotations.UseMockApi
import ru.ibaevzz.vibehack.utils.BASE_URL
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor(HttpLogger()).apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideUserApi(
        retrofit: Retrofit,
        @UseMockApi useMock: Boolean
    ): UserApi {
        return if (useMock) {
            MockUserApi
        } else {
            retrofit.create(UserApi::class.java)
        }
    }
}