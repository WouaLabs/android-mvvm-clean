package com.woua.mvvm.clean.cache

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@androidx.room.Database(
  entities = [ContactEntity::class],
  version = 1
)
abstract class Database : RoomDatabase() {

  abstract fun contactDao(): ContactDao

  companion object {

    private const val DB_NAME = "demo.db"

    @Volatile
    private var INSTANCE: Database? = null

    fun getInstance(context: Context): Database = INSTANCE ?: synchronized(this) {
      INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
    }

    private fun buildDatabase(context: Context) = Room.databaseBuilder(
      context.applicationContext, Database::class.java, DB_NAME
    ).fallbackToDestructiveMigration().build()

  }
}
