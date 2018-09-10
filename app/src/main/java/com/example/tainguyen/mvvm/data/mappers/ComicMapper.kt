package com.example.tainguyen.mvvm.data.mappers

import com.example.tainguyen.mvvm.data.network.models.Comic
import com.example.tainguyen.mvvm.data.network.models.Image
import com.example.tainguyen.mvvm.domain.mapper.Mapper
import com.example.tainguyen.mvvm.domain.models.ComicEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicMapper @Inject constructor() : Mapper<Comic, ComicEntity>() {
    override fun map(from: Comic): ComicEntity {
        return ComicEntity(
                id = from.id,
                title = from.title,
                description = from.variantDescription,
                prices = from.prices[0].price,
                thumbnail = from.thumbnail.fullPath,
                images = from.images.map(Image::fullPath)
        )
    }
}