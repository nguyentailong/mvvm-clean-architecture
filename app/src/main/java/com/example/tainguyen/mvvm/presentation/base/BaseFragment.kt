package com.example.tainguyen.mvvm.presentation.base

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tainguyen.mvvm.utils.RxEventBus
import com.squareup.leakcanary.RefWatcher
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    private val SAVED_STATE = "SAVED_STATE"

    protected var saveState: Bundle? = null

    protected var subscriptionsWhileActive: CompositeDisposable = CompositeDisposable()
    protected var subscriptionsWhileVisible: CompositeDisposable = CompositeDisposable()
    protected var subscriptionsWhileInMemory: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var leakCanaryRefWatcher: RefWatcher

    @Inject
    lateinit var eventBus: RxEventBus

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onPause() {
        super.onPause()
        subscriptionsWhileActive.clear()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSavedState(savedInstanceState)
    }

    private fun loadSavedState(savedInstanceState: Bundle?) {
        saveState = when {
            savedInstanceState != null && savedInstanceState.containsKey(SAVED_STATE) -> savedInstanceState.getBundle(SAVED_STATE)
            else -> Bundle()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBundle(SAVED_STATE, saveState)
    }

    override fun onStop() {
        super.onStop()
        subscriptionsWhileVisible.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptionsWhileInMemory.clear()
        try {
            leakCanaryRefWatcher.watch(this)
        } catch (e: Exception) {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }


}
