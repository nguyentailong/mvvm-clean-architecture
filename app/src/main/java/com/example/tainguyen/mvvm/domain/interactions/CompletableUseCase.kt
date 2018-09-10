package com.example.tainguyen.mvvm.domain.interactions

import io.reactivex.Completable


interface CompletableUseCase {
    fun execute(): Completable
}