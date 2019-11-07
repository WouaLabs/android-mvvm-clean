package com.woua.mvvm.clean.domain

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class UseCase<REQ : UseCase.RequestValues, RES : UseCase.ResponseValue> constructor(
  private val threadExecutor: ThreadExecutor, private val postExecutionThread: PostExecutionThread
) {

  private val disposables = CompositeDisposable()

  protected abstract fun buildUseCaseSingle(requestValues: REQ? = null): Single<RES>

  open fun execute(singleObserver: DisposableSingleObserver<RES>) {
    val single = this.buildUseCaseSingle(requestValues).subscribeOn(
      Schedulers.from(threadExecutor)
    ).observeOn(postExecutionThread.scheduler) as Single<RES>
    addDisposable(single.subscribeWith(singleObserver))
  }

  fun dispose() {
    if (!disposables.isDisposed) disposables.dispose()
  }

  private fun addDisposable(disposable: Disposable) {
    disposables.add(disposable)
  }

  var requestValues: REQ? = null

  interface RequestValues

  interface ResponseValue

}