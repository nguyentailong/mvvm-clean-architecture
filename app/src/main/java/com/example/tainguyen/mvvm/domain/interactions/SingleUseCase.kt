package com.example.tainguyen.mvvm.domain.interactions

import io.reactivex.Single

interface SingleUseCase<T> {
    fun execute(): Single<T>
}
