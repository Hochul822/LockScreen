package com.hcstudio.lockscreen.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "content_table")
class Content(
        @NonNull
        @field:PrimaryKey(autoGenerate = true)
        var id: Int,
        var title: String,
        var content: String,
        var date: Long,
        var language: String
)