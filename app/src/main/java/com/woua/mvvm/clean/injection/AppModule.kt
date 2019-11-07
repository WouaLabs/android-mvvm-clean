package com.woua.mvvm.clean.injection

import android.content.Context
import com.woua.mvvm.clean.FooApplication
import com.woua.mvvm.clean.data.DataSource
import com.woua.mvvm.clean.data.DataSourceImpl
import com.woua.mvvm.clean.data.JobExecutor
import com.woua.mvvm.clean.data.UiThread
import com.woua.mvvm.clean.domain.PostExecutionThread
import com.woua.mvvm.clean.domain.ThreadExecutor
import com.woua.mvvm.clean.domain.UseCaseHandler
import dagger.Module
import dagger.Provides

@Module
open class AppModule {
  @Provides
  @ApplicationScoped
  fun application(application: FooApplication): Context {
    return application
  }

  @Provides
  @ApplicationScoped
  fun dataSource(context: Context): DataSource {
    return DataSourceImpl.getInstance(context)
  }

  @ApplicationScoped
  @Provides
  fun jobExecutor(jobExecutor: JobExecutor): ThreadExecutor {
    return jobExecutor
  }

  @ApplicationScoped
  @Provides
  fun uiThread(uiThread: UiThread): PostExecutionThread {
    return uiThread
  }

  @ApplicationScoped
  @Provides
  fun usecaseHandler(): UseCaseHandler {
    return UseCaseHandler.getInstance
  }
}