package com.woua.mvvm.clean.domain

import io.reactivex.Scheduler
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class UseCaseHandler @Inject constructor() {

  fun <REQ : UseCase.RequestValues, RES : UseCase.ResponseValue> execute(
    useCase: UseCase<REQ, RES>, values: REQ, singleObserver: DisposableSingleObserver<RES>
  ) {

    useCase.requestValues = values
    useCase.execute(singleObserver)
  }

  companion object {

    private var INSTANCE: UseCaseHandler? = null

    val getInstance: UseCaseHandler
      get() {
        if (INSTANCE == null) {
          INSTANCE = UseCaseHandler()
        }
        return INSTANCE!!
      }
  }
}