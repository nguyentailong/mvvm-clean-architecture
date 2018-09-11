package com.example.tainguyen.mvvm.utils

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.concurrent.schedule

@Singleton
class RxEventBus @Inject constructor() {

    @Volatile
    private var isLocked: Boolean = false

    private val timer = Timer()

    private val bus = PublishSubject.create<Any>()

    fun publish(event: Any) = bus.onNext(event)

    /**
     * Publish an event
     * @param lockOutTime This params is used to prevent double clicking
     * @param event event to publish into PublishSubject
     */
    fun publishWithLock(event: Any, lockOutTime: Long = 500) {
        if (isLocked) return
        isLocked = true
        publish(event)
        timer.schedule(lockOutTime) { isLocked = false }
    }

    fun <T> listenTo(clazz: Class<T>): Observable<T> = bus.ofType(clazz)

    fun hasObservers(): Boolean = bus.hasObservers()
}