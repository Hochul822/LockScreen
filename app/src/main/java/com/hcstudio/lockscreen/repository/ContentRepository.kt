package com.hcstudio.lockscreen.repository

import android.app.Application
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import com.hcstudio.lockscreen.dao.ContentDao
import com.hcstudio.lockscreen.database.AppDatabase
import com.hcstudio.lockscreen.model.Content
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ContentRepository(application: Application) : LifecycleObserver {
    private val mContentDao: ContentDao
    private val mAllContent: LiveData<List<Content>>
    private val disposable: CompositeDisposable = CompositeDisposable()

    init {
        val db: AppDatabase = AppDatabase.getDatabase(application)!!
        mContentDao = db.contentDao()
        mAllContent = mContentDao.getAllContent()
    }

    fun getAllContent(): LiveData<List<Content>> {
        return mAllContent
    }

    fun insert(content: Content) {
        Single.just(true)
                .subscribeOn(Schedulers.io())
                .subscribe({
                    mContentDao.insertContent(content)
                }, {
                    it.printStackTrace()
                })
    }
}