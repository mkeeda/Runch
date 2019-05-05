package com.mkeeda.runch.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mkeeda.runch.R
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
    private val disposeBag = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)
    }

    override fun onDestroy() {
        super.onDestroy()
        this.disposeBag.clear()
    }
}
