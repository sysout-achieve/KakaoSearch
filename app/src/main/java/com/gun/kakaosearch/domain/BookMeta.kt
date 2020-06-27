package com.gun.kakaosearch.domain

import com.google.gson.annotations.SerializedName

data class BookMeta(
    @SerializedName("is_end") val isEnd: Boolean,
    @SerializedName("total_count") val totalCount: Int,
    @SerializedName("pageable_count") val pageableCount: Int
)