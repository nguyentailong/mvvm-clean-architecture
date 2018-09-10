package com.example.tainguyen.mvvm.dagger.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.tainguyen.mvvm.dagger.ViewModelKey
import com.example.tainguyen.mvvm.presentation.ListActivityViewModel
import com.example.tainguyen.mvvm.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListActivityViewModel::class)
    abstract fun bindMainViewModel(viewModel: ListActivityViewModel): ViewModel
}