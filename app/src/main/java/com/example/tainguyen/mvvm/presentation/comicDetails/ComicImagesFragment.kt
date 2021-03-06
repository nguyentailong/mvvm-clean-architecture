package com.example.tainguyen.mvvm.presentation.comicDetails

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.example.tainguyen.mvvm.R
import com.example.tainguyen.mvvm.presentation.base.BaseFragment
import com.example.tainguyen.mvvm.utils.loadImage
import com.example.tainguyen.mvvm.utils.observe
import kotlinx.android.synthetic.main.fragment_comic_images.*
import javax.inject.Inject

class ComicImagesFragment : BaseFragment() {
    @Inject
    lateinit var comicDetailsViewModel: ComicDetailsViewModel

    override val layoutId: Int = R.layout.fragment_comic_images

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comicDetailsViewModel = ViewModelProviders.of(requireActivity(), viewModelFactory).get(comicDetailsViewModel.javaClass)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(comicDetailsViewModel.comicDetails) { it ->
            if (it != null) {
                when {
                    it.images.isNotEmpty() -> comicImage.loadImage(it.images[0])
                    else -> comicImage.loadImage(it.thumbnail)
                }
            }
        }
    }
}
