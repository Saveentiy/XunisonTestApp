package xunison.com.testapp.di.module


import dagger.*

import java.util.concurrent.TimeUnit
import javax.inject.Named

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xunison.com.testapp.data.BuildConfig
import xunison.com.testapp.data.TIME_OUT

@Module
open class HttpModule {

    @Provides
    open fun provideOkHttp(
            serviceInterceptor: ServiceInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                addInterceptor(serviceInterceptor)
                connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                readTimeout(TIME_OUT, TimeUnit.SECONDS)
                writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                if (BuildConfig.DEBUG) addInterceptor(
                    HttpLoggingInterceptor().setLevel(
                        HttpLoggingInterceptor.Level.BODY
                    )
                )
            }
            .build()
    }

    @Provides
    @Named("auth_api")
    open fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}