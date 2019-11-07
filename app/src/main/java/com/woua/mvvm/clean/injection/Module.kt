package com.woua.mvvm.clean.injection

import com.woua.mvvm.clean.data.RepositoryImpl
import com.woua.mvvm.clean.domain.Repository
import dagger.Module
import dagger.Provides

@Module
open class Module {
  @Provides
  fun repository(repositoryImpl: RepositoryImpl): Repository = repositoryImpl
}