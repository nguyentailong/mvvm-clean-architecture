package com.example.tainguyen.mvvm.presentation.base

import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

//
//abstract class BaseActivityWithFragments : BaseActivity(), HasSupportFragmentInjector, HasFragmentInjector {
//    @Inject
//     var supportFragmentInjector: DispatchingAndroidInjector<Fragment>? = null
//    @Inject
//    internal var frameworkFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>? = null
//
//    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
//        return supportFragmentInjector
//    }
//
//    override fun fragmentInjector(): AndroidInjector<android.app.Fragment>? {
//        return frameworkFragmentInjector
//    }
//}
