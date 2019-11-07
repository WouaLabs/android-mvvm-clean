package com.woua.mvvm.clean

import android.app.Activity
import android.app.Application
import com.woua.mvvm.clean.injection.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class FooApplication : Application(), HasActivityInjector {

  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>

  override fun activityInjector(): AndroidInjector<Activity>? = activityInjector

  override fun onCreate() {
    super.onCreate()
    DaggerAppComponent.builder().application(this).build().inject(this)
  }
}