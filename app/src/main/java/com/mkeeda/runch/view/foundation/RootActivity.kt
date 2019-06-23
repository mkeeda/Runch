package com.mkeeda.runch.view.foundation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mkeeda.runch.R
import io.reactivex.disposables.CompositeDisposable

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
