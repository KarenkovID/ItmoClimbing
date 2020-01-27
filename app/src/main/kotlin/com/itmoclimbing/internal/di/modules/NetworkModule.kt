package com.itmoclimbing.internal.di.modules

import com.itmoclimbing.dataCommon.network.api.RoutesApi
import com.itmoclimbing.dataCommon.network.api.UsersApi
import com.kommander.components.android.network.TimberHttpLogger
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import toothpick.config.Module
import toothpick.ktp.binding.bind
import java.util.concurrent.TimeUnit

class NetworkModule : Module() {

    companion object {
        private const val TIMEOUT_CONNECT = 10L
        private const val TIMEOUT_WRITE = 10L
        private const val TIMEOUT_READ = 30L

        private const val BASE_URL = "http://agentdolphin.ru:9090/"
    }

    private val loggingInterceptor: HttpLoggingInterceptor =
            HttpLoggingInterceptor(TimberHttpLogger()).apply { level = HttpLoggingInterceptor.Level.BODY }

    private val moshi: Moshi = Moshi.Builder().build()

    private val okhttpClient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

    private val converterFactory: MoshiConverterFactory = MoshiConverterFactory.create(moshi)

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()

    private val routesApi: RoutesApi =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(RoutesApi::class.java)

    private val usersApi: UsersApi =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
                    .create(UsersApi::class.java)

    init {
        bind<Moshi>().toInstance(moshi)
        bind<HttpLoggingInterceptor>().toInstance(loggingInterceptor)
        bind<OkHttpClient>().toInstance(okhttpClient)
        bind<RoutesApi>().toInstance(routesApi)
        bind<UsersApi>().toInstance(usersApi)
    }

}