package com.example.tainguyen.mvvm.presentation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.tainguyen.mvvm.R
import com.example.tainguyen.mvvm.domain.models.ComicPagination
import com.example.tainguyen.mvvm.presentation.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class ListActivity(override val layoutId: Int = R.layout.activity_list, override val backButton: Boolean = false) : BaseActivity() {
    @Inject
    lateinit var listActivityViewModel: ListActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModelProviders.of(this, viewModelFactory).get(listActivityViewModel.javaClass)
    }

    override fun onStart() {
        super.onStart()
        listActivityViewModel.listComic.observe(this, postListObserver)
    }

    private val postListObserver = Observer<ComicPagination> { Timber.d(it.toString()) }
}
