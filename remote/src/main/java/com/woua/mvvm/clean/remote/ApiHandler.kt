package com.woua.mvvm.clean.remote

import io.reactivex.Single

interface ApiHandler {
  fun getContactList(): Single<List<Response>>
}