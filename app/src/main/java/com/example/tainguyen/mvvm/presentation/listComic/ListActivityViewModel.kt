package com.example.tainguyen.mvvm.presentation.listComic

import android.arch.lifecycle.MutableLiveData
import com.example.tainguyen.mvvm.MyApplication
import com.example.tainguyen.mvvm.domain.interactions.comic.GetComicListUseCase
import com.example.tainguyen.mvvm.domain.models.ComicPagination
import com.example.tainguyen.mvvm.presentation.base.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

class ListActivityViewModel @Inject constructor(application: MyApplication,
                                                getComicListUseCase: GetComicListUseCase) : BaseViewModel(application) {
    var listComic: MutableLiveData<ComicPagination> = MutableLiveData()

    init {
        compositeDisposable.add(getComicListUseCase.execute()
                .doOnSuccess { listComic.value = it }
                .doOnError { Timber.e(it) }
                .subscribe())
    }

}