package com.example.tainguyen.mvvm.data.mappers

import com.example.tainguyen.mvvm.data.network.models.ComicResponse
import com.example.tainguyen.mvvm.domain.mapper.Mapper
import com.example.tainguyen.mvvm.domain.models.ComicPagination
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicListMapper @Inject constructor(private val comicMapper: ComicMapper) : Mapper<ComicResponse, ComicPagination>() {
    override fun map(from: ComicResponse): ComicPagination = ComicPagination(
            offset = from.data?.offset,
            limit = from.data?.limit,
            total = from.data?.total,
            count = from.data?.count,
            comics = comicMapper.map(from.data?.results)
    )
}
