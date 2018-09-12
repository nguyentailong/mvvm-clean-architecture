package com.example.tainguyen.mvvm.presentation.comicDetails

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.tainguyen.mvvm.R
import com.example.tainguyen.mvvm.presentation.base.BaseFragment
import javax.inject.Inject

class ComicImagesFragment : BaseFragment() {
    @Inject
    lateinit var comicDetailsViewModel: ComicDetailsViewModel

    override val layoutId: Int = R.layout.fragment_comic_images

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comicDetailsViewModel = ViewModelProviders.of(requireActivity(), viewModelFactory).get(comicDetailsViewModel.javaClass)
    }

}