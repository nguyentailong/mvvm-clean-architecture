package com.example.tainguyen.mvvm.dagger

import com.example.tainguyen.mvvm.presentation.comicDetails.ComicDetailsActivity
import com.example.tainguyen.mvvm.presentation.listComic.ListActivity
import com.example.tainguyen.mvvm.presentation.listComic.ListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ListActivityModule::class])
    internal abstract fun listActivity(): ListActivity

    @ContributesAndroidInjector
    abstract fun comicDetailsActivity(): ComicDetailsActivity

}
