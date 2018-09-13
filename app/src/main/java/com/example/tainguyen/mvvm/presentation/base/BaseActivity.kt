package com.example.tainguyen.mvvm.presentation.base

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.MenuItem
import com.example.tainguyen.mvvm.utils.RxEventBus
import com.squareup.leakcanary.RefWatcher
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import javax.inject.Inject


abstract class BaseActivity : DaggerAppCompatActivity() {

    private val SAVED_STATE = "SAVED_STATE"
    protected var saveState: Bundle? = null

    protected var subscriptionsWhileVisible: CompositeDisposable = CompositeDisposable()
    protected var subscriptionsWhileInMemory: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var rxEventBus: RxEventBus

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var leakCanaryRefWatcher: RefWatcher

    @get:LayoutRes
    abstract val layoutId: Int

    /**
     * noBackButton has default value is false means activity has back button by default
     */
    open val noBackButton: Boolean = false

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        loadSavedState(savedInstanceState)
        setUpToolbar()
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

    private fun setUpToolbar() {
        supportActionBar?.apply {
            setHomeButtonEnabled(!noBackButton)
            setDisplayHomeAsUpEnabled(!noBackButton)
        }
    }


    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(menuItem)
    }

    override fun onBackPressed() {
        when {
            supportFragmentManager.backStackEntryCount == 1 -> finish()
            else -> super.onBackPressed()
        }
    }

    override fun onStop() {
        super.onStop()
        subscriptionsWhileVisible.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptionsWhileInMemory.clear()
    }
}
