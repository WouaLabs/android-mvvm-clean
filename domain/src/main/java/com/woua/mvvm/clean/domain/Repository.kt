package com.woua.mvvm.clean.domain

import io.reactivex.Single

interface Repository {
  fun getContactList(): Single<ContactListUsecase.ResponseValues>
}