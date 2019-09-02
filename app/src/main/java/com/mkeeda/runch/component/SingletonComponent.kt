package com.mkeeda.runch.component

import com.mkeeda.runch.api.gnavi.GnaviApiRequestInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.Date

class SingletonComponent {
    val retrofit: Retrofit

    init {
        this.retrofit = this.createRetrofit()
    }

    private fun createRetrofit(): Retrofit {
        val httpClientBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        httpClientBuilder
                .addInterceptor(GnaviApiRequestInterceptor())
                .addNetworkInterceptor(httpLoggingInterceptor)
                .build()

        val moshiConverterFactory = MoshiConverterFactory.create(
                Moshi.Builder()
                        .add(Date::class.java, Rfc3339DateJsonAdapter())
                        .add(KotlinJsonAdapterFactory())
                        .build())

        return Retrofit.Builder()
                .baseUrl("https://api.gnavi.co.jp")
                .addConverterFactory(moshiConverterFactory)
                .client(httpClientBuilder.build())
                .build()
    }
}
