package com.woua.mvvm.clean.remote

class ApiHandlerImpl(private val restApi: RestApi) : ApiHandler {
  override fun getContactList() = restApi.getContactList()
}