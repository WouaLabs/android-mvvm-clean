package com.woua.mvvm.clean.data

import com.woua.mvvm.clean.domain.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

open class UiThread @Inject constructor() : PostExecutionThread {
  override val scheduler: Scheduler = AndroidSchedulers.mainThread()
}
