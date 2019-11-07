package com.woua.mvvm.clean.injection

import com.woua.mvvm.clean.FooActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
  includes = [ViewModelModule::class, com.woua.mvvm.clean.injection.Module::class]
)
abstract class ActivityBuilder {

  @ContributesAndroidInjector
  abstract fun foo(): FooActivity
}