package com.example.tainguyen.mvvm.dagger.module

import com.example.tainguyen.mvvm.data.managers.ComicManager
import com.example.tainguyen.mvvm.domain.repositories.ComicRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class DataModule {

    @Binds
    @Singleton
    internal abstract fun comicRepository(comicManager: ComicManager): ComicRepository

}
