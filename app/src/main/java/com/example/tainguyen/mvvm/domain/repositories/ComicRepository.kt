package com.example.tainguyen.mvvm.domain.repositories

import com.example.tainguyen.mvvm.domain.models.ComicEntity
import com.example.tainguyen.mvvm.domain.models.ComicPagination
import io.reactivex.Single


interface ComicRepository {
    fun getComics(): Single<ComicPagination>
    fun getComicDetails(comicId: String): Single<ComicEntity>
}