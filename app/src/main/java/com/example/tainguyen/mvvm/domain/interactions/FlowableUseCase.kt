package com.example.tainguyen.mvvm.domain.interactions

import io.reactivex.Flowable

interface FlowableUseCase<T> {
    fun execute(): Flowable<T>
}

