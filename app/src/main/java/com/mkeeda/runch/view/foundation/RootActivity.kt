package com.mkeeda.runch.view.foundation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mkeeda.runch.R

class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)
    }
}
