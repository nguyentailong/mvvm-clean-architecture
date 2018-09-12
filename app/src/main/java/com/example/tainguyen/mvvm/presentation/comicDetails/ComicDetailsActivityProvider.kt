package com.example.tainguyen.mvvm.presentation.comicDetails

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ComicDetailsActivityProvider {

    @ContributesAndroidInjector
    internal abstract fun comicImagesFragment(): ComicImagesFragment

    @ContributesAndroidInjector
    internal abstract fun comicDetailsFragment(): ComicDetailsFragment
}
