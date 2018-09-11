package com.example.tainguyen.mvvm.utils

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

inline fun <T> LiveData<T>.observes(owner: LifecycleOwner, crossinline observer: (T?) -> Unit) = observe(owner, Observer { observer(it) })

inline fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner, crossinline observer: (T) -> Unit) = observe(owner, Observer { observer(it!!) })

inline fun <T> LifecycleOwner.observe(liveData: LiveData<T>, crossinline observer: (T?) -> Unit) = liveData.observe(this, Observer { observer(it) })

inline fun <T> LifecycleOwner.observeNotNull(liveData: LiveData<T>, crossinline observer: (T?) -> Unit) = liveData.observe(this, Observer { it -> it?.let { observer(it) } })