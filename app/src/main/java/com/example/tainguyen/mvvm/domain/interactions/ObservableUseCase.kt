package com.example.tainguyen.mvvm.domain.interactions

import io.reactivex.Observable

interface ObservableUseCase<T> {
    fun execute(): Observable<T>
}
