package com.woua.mvvm.clean.remote

interface RemoteSource {
  fun handler(): ApiHandler
}