package com.hcstudio.lockscreen.view

import android.app.WallpaperManager
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hcstudio.lockscreen.R
import com.hcstudio.lockscreen.ScreenService
import com.hcstudio.lockscreen.base.BaseActivity
import com.hcstudio.lockscreen.model.Content
import com.hcstudio.lockscreen.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

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


        val model = ViewModelProviders.of(this).get(MainViewModel::class.java)
        model.getContent().observe(this, Observer<Content> {
            it?.let {
                content_title.text = it.title
                content_tip.text = it.content
            }
        })

        val content = Content()
        content.title = "오늘의 안드로이드 개발팁"
        content.content = "8.0부터는 백그라운드 서비스 제한이 걸리는 걸 알고 계셨나요?"
        model.setContent(content)
    }

    private fun setLayout() {
        val wallPaper = WallpaperManager.getInstance(this)
        val drawable = wallPaper.drawable
        main_layout.background = drawable
    }
}
