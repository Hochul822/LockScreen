package com.hcstudio.lockscreen.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.hcstudio.lockscreen.model.Content

class MainViewModel: ViewModel() {
    val content = MutableLiveData<Content>()

    fun getContent(): LiveData<Content> {
        return content
    }

    fun setContent(content: Content) {
        this.content.value = content
    }
}