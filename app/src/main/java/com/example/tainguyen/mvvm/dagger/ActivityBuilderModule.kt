package com.example.tainguyen.mvvm.dagger

import com.example.tainguyen.mvvm.presentation.ListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    internal abstract fun listActivity(): ListActivity
//
//    @ContributesAndroidInjector(modules = [CreateItemActivityProvider::class])
//    abstract fun createItemActivity(): CreateItemActivity


}
