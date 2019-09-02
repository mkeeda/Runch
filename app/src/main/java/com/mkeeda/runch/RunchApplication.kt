package com.mkeeda.runch

import android.app.Application
import com.mkeeda.runch.component.SingletonComponent

class RunchApplication: Application() {
    companion object {
        private var _singleton: SingletonComponent? = null
        val singleton: SingletonComponent
            get() = _singleton ?: throw IllegalStateException("Singleton component is not initialized")
    }

    override fun onCreate() {
        super.onCreate()
        _singleton = SingletonComponent()
    }
}
