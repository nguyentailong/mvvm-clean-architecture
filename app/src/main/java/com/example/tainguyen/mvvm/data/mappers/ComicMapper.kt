package com.example.tainguyen.mvvm.data.mappers

import com.example.tainguyen.mvvm.data.network.models.ComicEntity
import com.example.tainguyen.mvvm.data.network.models.Image
import com.example.tainguyen.mvvm.domain.mapper.Mapper
import com.example.tainguyen.mvvm.domain.models.Comic
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicMapper @Inject constructor() : Mapper<ComicEntity, Comic>() {
    override fun map(from: ComicEntity): Comic = Comic(
            id = from.id,
            title = from.title,
            description = from.variantDescription,
            prices = from.prices[0].price,
            thumbnail = from.thumbnail.fullPath,
            images = from.images.map(Image::fullPath)
    )
}