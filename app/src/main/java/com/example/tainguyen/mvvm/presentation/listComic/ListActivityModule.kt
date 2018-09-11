package com.example.tainguyen.mvvm.presentation.listComic

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.OrientationHelper
import com.example.tainguyen.mvvm.utils.RxEventBus
import dagger.Module
import dagger.Provides

@Module
class ListActivityModule {

    @Provides
    internal fun provideComicAdapter(listActivity: ListActivity, rxEventBus: RxEventBus): ComicAdapter = ComicAdapter(rxEventBus = rxEventBus)

    @Provides
    internal fun provideDividerItemDecoration(listActivity: ListActivity): DividerItemDecoration = DividerItemDecoration(listActivity, OrientationHelper.VERTICAL)

}
