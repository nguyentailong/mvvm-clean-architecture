package com.example.tainguyen.mvvm.data.network.models

import com.google.gson.annotations.SerializedName

open class BaseResponse<out ResponseType>(@SerializedName("code") val code: Int? = null,
                                          @SerializedName("status") val status: String? = null,
                                          @SerializedName("data") val data: ListResponse<ResponseType>? = null)


data class ListResponse<out ResponseType>(@SerializedName("offset") val offset: Int,
                                          @SerializedName("limit") val limit: Int,
                                          @SerializedName("total") val total: Int,
                                          @SerializedName("count") val count: Int,
                                          @SerializedName("results") val results: List<ResponseType>)