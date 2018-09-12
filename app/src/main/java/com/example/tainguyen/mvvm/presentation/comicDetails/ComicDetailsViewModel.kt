package com.example.tainguyen.mvvm.presentation.comicDetails

import android.arch.lifecycle.MutableLiveData
import com.example.tainguyen.mvvm.MyApplication
import com.example.tainguyen.mvvm.domain.interactions.comic.GetComicDetailsUseCase
import com.example.tainguyen.mvvm.domain.models.Comic
import com.example.tainguyen.mvvm.presentation.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class ComicDetailsViewModel @Inject constructor(application: MyApplication,
                                                private val getComicDetailsUseCase: GetComicDetailsUseCase) : BaseViewModel(application) {
    var comicDetails: MutableLiveData<Comic> = MutableLiveData()

    fun fetchComicDetails(comicId: String) {
        getComicDetailsUseCase.comicId = comicId
        compositeDisposable.add(getComicDetailsUseCase.execute()
                .doOnSuccess { comicDetails.value = it }
                .doOnError { Timber.e(it) }
                .subscribe())

    }

}