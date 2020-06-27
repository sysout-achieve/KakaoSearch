package com.gun.kakaosearch.domain

import com.google.gson.annotations.SerializedName

data class ResultBook(
    @SerializedName("meta") val meta: BookMeta,
    @SerializedName("documents") val bookList: List<Book>
) {
    fun isEmpty() = bookList.isEmpty()
    fun isEnd() = meta.isEnd
}