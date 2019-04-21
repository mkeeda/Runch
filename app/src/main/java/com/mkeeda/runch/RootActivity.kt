package com.mkeeda.runch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mkeeda.runch.api.gnavi.GnaviApiRequestInterceptor
import com.mkeeda.runch.domainimpl.repository.RestSearchRepositoryImpl
import com.mkeeda.runchdomain.extension.disposed
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

class RootActivity : AppCompatActivity() {
    val disposeBag = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder
            .addInterceptor(GnaviApiRequestInterceptor())
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val moshiConverterFactory = MoshiConverterFactory.create(
            Moshi.Builder()
                .add(Date::class.java, Rfc3339DateJsonAdapter())
                .add(KotlinJsonAdapterFactory())
                .build())
        val rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.gnavi.co.jp")
            .addConverterFactory(moshiConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .client(httpClientBuilder.build())
            .build()

        RestSearchRepositoryImpl(retrofit = retrofit).retrieveRandom5ByLocation(latitude = 35.682444, longitude = 139.773611)
            .subscribe { item ->
                println("⭐$item")
            }.disposed(by = disposeBag)
    }

    override fun onDestroy() {
        super.onDestroy()
        this.disposeBag.clear()
    }
}
