package com.example.tainguyen.mvvm.data.network.models

import com.google.gson.annotations.SerializedName

class ComicResponse : BaseResponse<ComicEntity>()

data class ComicEntity(@SerializedName("id") val id: String,
                       @SerializedName("title") val title: String,
                       @SerializedName("variantDescription") val variantDescription: String,
                       @SerializedName("prices") val prices: List<Price>,
                       @SerializedName("thumbnail") val thumbnail: Image,
                       @SerializedName("images") val images: List<Image>
)

data class Price(@SerializedName("price") val price: Double,
                 @SerializedName("type") val printPrice: String
)

data class Image(@SerializedName("path") val path: String,
                 @SerializedName("extension") val extension: String) {
    val fullPath: String
        get() = "$path.$extension"
}

