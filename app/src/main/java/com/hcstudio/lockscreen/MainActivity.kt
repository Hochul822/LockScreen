package com.hcstudio.lockscreen

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val i = Intent(this, ScreenService::class.java)
        startService(i)

        on.setOnClickListener {
            val i = Intent(this, ScreenService::class.java)
            startService(i)
        }

        off.setOnClickListener {
            val i = Intent(this, ScreenService::class.java)
            stopService(i)
        }
    }
}
