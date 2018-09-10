package com.example.tainguyen.mvvm.domain.interactions.comic

import com.example.tainguyen.mvvm.domain.interactions.SingleUseCase
import com.example.tainguyen.mvvm.domain.models.ComicPagination
import com.example.tainguyen.mvvm.domain.repositories.ComicRepository
import com.example.tainguyen.mvvm.executor.Schedulers
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetComicListUseCase @Inject constructor(private val schedulers: Schedulers,
                                              private val comicRepository: ComicRepository) : SingleUseCase<ComicPagination> {
    override fun execute(): Single<ComicPagination> {
        return comicRepository.getComics()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
    }
}