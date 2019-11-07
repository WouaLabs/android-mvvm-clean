package com.woua.mvvm.clean.remote

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.*

class RemoteSourceImpl(context: Context) : RemoteSource {

  private val restApi: RestApi = restApi()
  private var apiHandler: ApiHandlerImpl = ApiHandlerImpl(restApi)

  companion object {
    const val CONNECT_TIME_OUT = 90
    const val READ_TIME_OUT = 90
  }

  override fun handler(): ApiHandler = apiHandler

  private fun restApi(): RestApi {
    return build(
      "https://firebasestorage.googleapis.com",
      getOkHttpClient(),
      createGsonConverterFactory()
    ).create(
      RestApi::class.java
    )
  }

  private fun build(
    baseUrl: String, okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory
  ): Retrofit {

    return Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
      .addConverterFactory(gsonConverterFactory)
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
  }

  private fun getOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()
    builder.connectTimeout(CONNECT_TIME_OUT.toLong(), TimeUnit.SECONDS)
    builder.readTimeout(READ_TIME_OUT.toLong(), TimeUnit.SECONDS)

    if (BuildConfig.DEBUG) {
      val logging = HttpLoggingInterceptor()
      logging.level = HttpLoggingInterceptor.Level.BODY
      builder.addInterceptor(logging)
    }
    // interceptor for logging
    return builder.build()
  }

  private fun createGsonConverterFactory(): GsonConverterFactory {
    val gson = GsonBuilder()
      .excludeFieldsWithoutExposeAnnotation().create()
    return GsonConverterFactory.create(gson)
  }
}