package com.mkeeda.runch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mkeeda.runch.view.login.LoginActivity

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        val loginIntent = Intent(this, LoginActivity::class.java)
        this.startActivity(loginIntent)
    }
}
