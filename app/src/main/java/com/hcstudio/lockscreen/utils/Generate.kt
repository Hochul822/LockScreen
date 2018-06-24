package com.hcstudio.lockscreen.utils

import com.hcstudio.lockscreen.model.Content
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

object Generate {

    fun createContentsLocal(): ArrayList<Content> {
        val list = ArrayList<Content>()
        val titleList = arrayOf("점심은 무얼 먹을까요", "오늘은 무얼 할까요", "직장 상사가 결정장애이면은 어떻게할까요?", "팀장이 자꾸 마이크로 매니징을 하네요")
        val contentList = arrayOf("배고프네요", "정답은 없습니다", "빨리 떠날 준비를 하세요", "지시 받기 전에 보고를 하세요. 시키는 일이 줄어들 겁니다")


        for(index in 0..titleList.size) {
            list.add(Content(index , titleList[index], contentList[index], 1987,  "kr" ))
        }

        return list
    }

    fun createContentsJson() {
        val obj = JSONObject()
        obj.put("title", "점심은 무엇인가요?")
        obj.put("content", "뭘 먹을까요?")

        val date = Date()
        obj.put("date", 1987)

        val array = JSONArray()
        array.put(obj)

    }
}