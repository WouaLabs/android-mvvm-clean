package com.woua.mvvm.clean.data

import android.content.Context
import com.woua.mvvm.clean.cache.CacheSource
import com.woua.mvvm.clean.cache.CacheSourceImpl
import com.woua.mvvm.clean.cache.Database
import com.woua.mvvm.clean.remote.RemoteSource
import com.woua.mvvm.clean.remote.RemoteSourceImpl
import javax.inject.Inject

class DataSourceImpl @Inject constructor(context: Context) : DataSource {

  private var cache: CacheSource =
    CacheSourceImpl(Database.getInstance(context.applicationContext))

  private var remote: RemoteSource = RemoteSourceImpl(
    context.applicationContext
  )

  companion object : SingletonHolder<DataSource, Context>(::DataSourceImpl)

  override fun remote(): RemoteSource = remote

  override fun cache(): CacheSource = cache

}