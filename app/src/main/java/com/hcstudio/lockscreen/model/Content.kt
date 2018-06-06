package com.hcstudio.lockscreen.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "content_table")
class Content {
    @NonNull
    @PrimaryKey
    var id: Int = 0
    var title: String = ""
    var content: String = ""
    var language: String = ""
    var date: Long = 0L
}