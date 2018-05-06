package com.hcstudio.lockscreen

import android.app.Application

/**
 * Created by hochul on 2018-05-05.
 */
class LockApplication: Application() {

    var lockScreenShow = false
    val notificationId = 1987

    override fun onCreate() {
        super.onCreate()
    }
}