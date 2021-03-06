package com.example.tainguyen.mvvm.domain.interactions.comic

import com.example.tainguyen.mvvm.domain.interactions.SingleUseCase
import com.example.tainguyen.mvvm.domain.models.Comic
import com.example.tainguyen.mvvm.domain.repositories.ComicRepository
import com.example.tainguyen.mvvm.executor.Schedulers
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetComicDetailsUseCase @Inject constructor(private val schedulers: Schedulers,
                                                 private val comicRepository: ComicRepository) : SingleUseCase<Comic> {
    lateinit var comicId: String
    override fun execute(): Single<Comic> {
        return comicRepository.getComicDetails(comicId)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
    }
}