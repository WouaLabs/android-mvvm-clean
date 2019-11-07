package com.woua.mvvm.clean.injection

import com.woua.mvvm.clean.FooApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScoped
@Component(modules = [AppModule::class, ActivityBuilder::class, AndroidSupportInjectionModule::class])
interface AppComponent {

  fun inject(application: FooApplication)

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun application(application: FooApplication): Builder

    fun build(): AppComponent
  }
}
