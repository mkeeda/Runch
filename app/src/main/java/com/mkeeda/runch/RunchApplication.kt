package com.mkeeda.runch

import android.app.Application
import com.mkeeda.runch.component.SingletonComponent

class RunchApplication: Application() {
    companion object {
        var singleton: SingletonComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        singleton = SingletonComponent()
    }
}
