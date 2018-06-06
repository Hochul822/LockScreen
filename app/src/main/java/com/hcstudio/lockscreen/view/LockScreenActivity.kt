package com.hcstudio.lockscreen.view

import android.app.WallpaperManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import com.hcstudio.lockscreen.R
import com.hcstudio.lockscreen.base.BaseActivity
import kotlinx.android.synthetic.main.activity_lock_screen.*

class LockScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock_screen)
        setLayout()
        exit.setOnClickListener {
            finish()
        }
    }

    override fun onAttachedToWindow() {
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN and
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onAttachedToWindow()
    }

    fun setLayout() {
        val wallPaper = WallpaperManager.getInstance(this)
        val drawable = wallPaper.drawable
        lock_layout.background = drawable
    }
}
