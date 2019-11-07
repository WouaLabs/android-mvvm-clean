package com.woua.mvvm.clean.cache

class CacheSourceImpl(var database: Database) : CacheSource {
  override fun contact(): ContactDao = database.contactDao()
}