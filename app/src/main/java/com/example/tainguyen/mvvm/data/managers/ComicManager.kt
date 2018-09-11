package com.example.tainguyen.mvvm.data.managers

import com.example.tainguyen.mvvm.data.mappers.ComicListMapper
import com.example.tainguyen.mvvm.data.mappers.ComicMapper
import com.example.tainguyen.mvvm.data.network.ComicService
import com.example.tainguyen.mvvm.domain.models.Comic
import com.example.tainguyen.mvvm.domain.models.ComicPagination
import com.example.tainguyen.mvvm.domain.repositories.ComicRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicManager @Inject constructor(private val comicService: ComicService,
                                       private val comicMapper: ComicMapper,
                                       private val comicListMapper: ComicListMapper) : ComicRepository {

    override fun getComics(): Single<ComicPagination> {
        return comicService.getComics()
                .map { it.body() }
                .map(comicListMapper::map)
    }

    override fun getComicDetails(comicId: String): Single<Comic> {
        return comicService.getComicDetails(comicId)
                .map { response ->
                    response.body()?.data?.results?.get(0)
                }
                .map(comicMapper::map)

    }
}