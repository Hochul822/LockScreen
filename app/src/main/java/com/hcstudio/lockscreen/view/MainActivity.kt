package com.hcstudio.lockscreen.view

import android.app.WallpaperManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hcstudio.lockscreen.R
import com.hcstudio.lockscreen.ScreenService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLayout()

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

    private fun setLayout() {
        val wallPaper = WallpaperManager.getInstance(this)
        val drawable = wallPaper.drawable
        main_layout.background = drawable
    }
}
