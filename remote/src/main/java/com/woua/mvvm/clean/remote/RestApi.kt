package com.woua.mvvm.clean.remote

import io.reactivex.Single
import retrofit2.http.GET

interface RestApi {
  @GET("/v0/b/api-demo-f6647.appspot.com/o/contacts.json?alt=media&token=7275ae23-3a65-49b6-8fe5-f8ff0c0cbc75")
  fun getContactList(): Single<List<Response>>
}