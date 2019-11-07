package com.woua.mvvm.clean.data

import com.woua.mvvm.clean.cache.CacheSource
import com.woua.mvvm.clean.remote.RemoteSource

interface DataSource {
  fun remote(): RemoteSource
  fun cache(): CacheSource
}