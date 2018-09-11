package com.example.tainguyen.mvvm.presentation.comicDetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.tainguyen.mvvm.R
import com.example.tainguyen.mvvm.presentation.base.BaseActivity

class ComicDetailsActivity(override val layoutId: Int = R.layout.activity_comic_details) : BaseActivity() {
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

