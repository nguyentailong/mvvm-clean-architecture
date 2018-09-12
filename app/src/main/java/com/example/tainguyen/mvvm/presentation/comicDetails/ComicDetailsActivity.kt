package com.example.tainguyen.mvvm.presentation.comicDetails

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.tainguyen.mvvm.R
import com.example.tainguyen.mvvm.presentation.base.BaseActivity
import javax.inject.Inject

class ComicDetailsActivity(override val layoutId: Int = R.layout.activity_comic_details) : BaseActivity() {
    @Inject
    lateinit var comicDetailsViewModel: ComicDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comicDetailsViewModel = ViewModelProviders.of(this, viewModelFactory).get(comicDetailsViewModel.javaClass)
        comicDetailsViewModel.fetchComicDetails(intent.getStringExtra(COMIC_ID))
    }
    companion object {
        private const val COMIC_ID = "comic.id"
        fun startActivity(context: Context, comicId: String) {
            val bundle = Bundle()
            bundle.putString(COMIC_ID, comicId)
            val intent = Intent(context, ComicDetailsActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }
}

