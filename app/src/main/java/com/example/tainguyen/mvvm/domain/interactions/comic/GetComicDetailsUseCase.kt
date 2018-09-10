package com.example.tainguyen.mvvm.domain.interactions.comic

import com.example.tainguyen.mvvm.domain.interactions.SingleUseCase
import com.example.tainguyen.mvvm.domain.models.ComicEntity
import com.example.tainguyen.mvvm.domain.repositories.ComicRepository
import com.example.tainguyen.mvvm.executor.Schedulers
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetComicDetailsUseCase @Inject constructor(private val schedulers: Schedulers,
                                                 private val comicRepository: ComicRepository) : SingleUseCase<ComicEntity> {
    lateinit var comicId: String
    override fun execute(): Single<ComicEntity> {
        return comicRepository.getComicDetails(comicId)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
    }
}