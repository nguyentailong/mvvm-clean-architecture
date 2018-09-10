package com.example.tainguyen.mvvm.domain.interactions

import io.reactivex.Maybe

interface MaybeUseCase<T> {
    fun execute(): Maybe<T>
}
