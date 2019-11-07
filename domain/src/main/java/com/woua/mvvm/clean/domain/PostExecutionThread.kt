package com.woua.mvvm.clean.domain

import io.reactivex.Scheduler

interface PostExecutionThread {
  val scheduler: Scheduler
}