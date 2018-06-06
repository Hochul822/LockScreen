package com.hcstudio.lockscreen.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.hcstudio.lockscreen.model.Content

@Dao
interface ContentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContent(context: Content)

    @Query("SELECT * from content_table ORDER BY date DESC")
    fun getAllContent(): LiveData<List<Content>>

    @Query("DELETE from content_table")
    fun deleteContent()
}