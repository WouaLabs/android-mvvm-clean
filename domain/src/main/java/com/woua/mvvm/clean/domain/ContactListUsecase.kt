package com.woua.mvvm.clean.domain

import io.reactivex.Single
import javax.inject.Inject

class ContactListUsecase @Inject constructor(
  private val repository: Repository,
  threadExecutor: ThreadExecutor,
  postExecutionThread: PostExecutionThread
) : UseCase<ContactListUsecase.RequestValues, ContactListUsecase.ResponseValues>(
  threadExecutor, postExecutionThread
) {

  override fun buildUseCaseSingle(requestValues: RequestValues?): Single<ResponseValues> {
    return repository.getContactList()
  }

  data class RequestValues @JvmOverloads constructor(var dummy: String = "") : UseCase.RequestValues

  data class ResponseValues(
    val isSuccess: Boolean = false
  ) : ResponseValue
}