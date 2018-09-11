package com.example.tainguyen.mvvm.presentation.listComic

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import com.example.tainguyen.mvvm.R
import com.example.tainguyen.mvvm.presentation.base.BaseActivity
import com.example.tainguyen.mvvm.presentation.comicDetails.ComicDetailsActivity
import com.example.tainguyen.mvvm.utils.hideLoading
import com.example.tainguyen.mvvm.utils.observe
import com.example.tainguyen.mvvm.utils.showLoading
import kotlinx.android.synthetic.main.activity_list.*
import timber.log.Timber
import javax.inject.Inject

class ListActivity(override val layoutId: Int = R.layout.activity_list, override val noBackButton: Boolean = true) : BaseActivity() {
    @Inject
    lateinit var listActivityViewModel: ListActivityViewModel
    @Inject
    lateinit var adapter: ComicAdapter
    @Inject
    lateinit var dividerItemDecoration: DividerItemDecoration

    companion object {
        fun open(context: Context): Intent {
            return Intent(context, ListActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(listActivityViewModel.javaClass)
        rv_comics.adapter = adapter
        rv_comics.addItemDecoration(dividerItemDecoration)
    }

    override fun onStart() {
        super.onStart()
        showLoading()
        initObservables()
    }

    private fun initObservables() {
        observe(listActivityViewModel.listComic) { it ->
            hideLoading()
            it?.comics?.let { adapter.data = it }
        }
        subscriptionsWhileVisible.add(rxEventBus.listenTo(OnComicSelectedEvent::class.java).subscribe {
            Timber.d("On Clicked ${it.comic.id}")
            ComicDetailsActivity.startActivity(this, it.comic.id)
        })
    }
}
