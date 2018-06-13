package com.hcstudio.lockscreen.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import com.hcstudio.lockscreen.dao.ContentDao
import com.hcstudio.lockscreen.model.Content
import java.util.*

@Database(entities = [(Content::class)], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun contentDao(): ContentDao

    private class PopulateDBAsync(db: AppDatabase) : AsyncTask<Void, Void, Void>() {
        private val mDao: ContentDao = db.contentDao()

        override fun doInBackground(vararg voids: Void): Void? {
            mDao.deleteContent()

            var content = Content(0 , "오늘은 무얼 할까요", "정답은 없습니다", 1987,  "kr" )
            mDao.insertContent(content)
            content = Content(0 , "점심은 무얼 먹을까요", "배고프네요", 1987,  "kr" )
            mDao.insertContent(content)
            return null
        }
    }

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            synchronized(lock = AppDatabase::class.java) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            AppDatabase::class.java
                            ,"lock-screen-database")
                            .addCallback(sRoomDatabaseCallback)
                            .build()
                }
            }
            return INSTANCE
        }

        val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDBAsync(INSTANCE!!).execute()
            }
        }
    }
}