package com.hcstudio.lockscreen.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.hcstudio.lockscreen.model.Content
import com.hcstudio.lockscreen.repository.ContentRepository

class MainViewModel: AndroidViewModel {
    var repository: ContentRepository
    val content = MutableLiveData<Content>()
    var allContent: LiveData<List<Content>>

    constructor(application: Application) : super(application) {
        repository = ContentRepository(application)
        allContent = repository.getAllContent()
    }

    fun getContent(): LiveData<Content> {
        return content
    }

    fun setContent(content: Content) {
        this.content.value = content
    }

    fun getAllContents(): LiveData<List<Content>> {
        return allContent
    }
}