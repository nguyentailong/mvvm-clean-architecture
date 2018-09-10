package com.example.tainguyen.mvvm.executor

import io.reactivex.Scheduler

interface Schedulers {
    fun ui(): Scheduler

    fun io(): Scheduler

    fun single(): Scheduler

    fun computation(): Scheduler

    fun trampoline(): Scheduler
}
