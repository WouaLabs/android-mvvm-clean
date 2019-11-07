package com.woua.mvvm.clean.data

import com.woua.mvvm.clean.cache.ContactEntity
import com.woua.mvvm.clean.domain.ContactListUsecase
import com.woua.mvvm.clean.domain.Repository
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val dataSource: DataSource) : Repository {
  override fun getContactList(): Single<ContactListUsecase.ResponseValues> {
    return dataSource.remote().handler().getContactList().flatMap {
      val list = ArrayList<ContactEntity>()
      for (response in it) {
        list.add(
          ContactEntity(
            response.id,
            response.first_name,
            response.last_name,
            response.profile_pic
          )
        )
      }
      dataSource.cache().contact().insertWithReplace(list)
      Single.just(ContactListUsecase.ResponseValues(true))
    }
  }
}