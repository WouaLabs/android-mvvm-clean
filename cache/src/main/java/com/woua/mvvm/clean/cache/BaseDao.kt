package com.woua.mvvm.clean.cache

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<T> {

  @Insert
  fun insert(t: T)

  @Insert(onConflict = OnConflictStrategy.FAIL)
  fun insertWithFail(t: T)

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun insertWithIgnore(t: T)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertWithReplace(t: T)

  @Insert(onConflict = OnConflictStrategy.ROLLBACK)
  fun insertWithRollback(t: T)

  @Insert
  fun insert(list: List<T>)

  @Insert(onConflict = OnConflictStrategy.FAIL)
  fun insertWithFail(list: List<T>)

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun insertWithIgnore(list: List<T>)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertWithReplace(list: List<T>)

  @Insert(onConflict = OnConflictStrategy.ROLLBACK)
  fun insertWithRollback(list: List<T>)

  @Delete
  fun delete(t: T)

  @Delete
  fun delete(list: List<T>)

}