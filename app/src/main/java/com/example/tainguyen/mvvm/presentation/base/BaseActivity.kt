package com.example.tainguyen.mvvm.presentation.base

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.View
import com.example.tainguyen.mvvm.utils.RxEventBus
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import javax.inject.Inject


abstract class BaseActivity : DaggerAppCompatActivity() {

    protected var subscriptionsWhileVisible: CompositeDisposable = CompositeDisposable()
    protected var subscriptionsWhileInMemory: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var eventBus: RxEventBus
    //
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @get:LayoutRes
    abstract val layoutId: Int

    abstract val backButton: Boolean


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        setUpToolbar()
    }

    private fun setUpToolbar() {
        supportActionBar?.apply {
            setHomeButtonEnabled(backButton)
            setDisplayHomeAsUpEnabled(backButton)
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
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

    fun showMessage(message: String, onClickListener: DialogInterface.OnClickListener) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message).setPositiveButton(android.R.string.ok, onClickListener).create().show()
    }

    fun showMessage(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(message).setPositiveButton(android.R.string.ok) { _, _ -> }.create().show()
    }

    fun addFragment(containerViewId: Int, fragment: Fragment, addToBackStack: Boolean) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        //        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        if (addToBackStack)
            transaction.addToBackStack(fragment.javaClass.name)
        transaction.replace(containerViewId, fragment, fragment.javaClass.name)
        transaction.commitAllowingStateLoss()
    }

    fun showSnackBar(text: String) {
        val container = findViewById<View>(android.R.id.content)
        if (container != null) {
            Snackbar.make(container, text, Snackbar.LENGTH_SHORT).show()
        }
    }
}
