package com.woua.mvvm.clean.injection

import androidx.lifecycle.ViewModel
import com.woua.mvvm.clean.FooViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule : BaseFactory() {
  @Binds
  @IntoMap
  @ViewModelKey(FooViewModel::class)
  abstract fun fooViewModel(fooViewModel: FooViewModel): ViewModel
}