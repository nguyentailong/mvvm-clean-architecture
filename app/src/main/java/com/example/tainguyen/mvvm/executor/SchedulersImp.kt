package com.example.tainguyen.mvvm.executor

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchedulersImp @Inject constructor() : Schedulers {

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun io(): Scheduler {
        return io.reactivex.schedulers.Schedulers.io()
    }

    override fun single(): Scheduler {
        return io.reactivex.schedulers.Schedulers.single()
    }

    override fun computation(): Scheduler {
        return io.reactivex.schedulers.Schedulers.computation()
    }

    override fun trampoline(): Scheduler {
        return io.reactivex.schedulers.Schedulers.trampoline()
    }
}