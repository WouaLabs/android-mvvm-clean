package com.woua.mvvm.clean.cache

import androidx.room.Entity

@Entity(
  tableName = "contact",
  primaryKeys = ["id"]
)
//One to many relationship with address
data class ContactEntity(
  var id: Int,
  var fistname: String?,
  var lastname: String?,
  var profilepic: String?
)