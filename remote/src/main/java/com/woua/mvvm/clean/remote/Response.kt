package com.woua.mvvm.clean.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response(
  @SerializedName("id") @Expose val id: Int,
  @SerializedName("first_name") @Expose val first_name: String?,
  @SerializedName("last_name") @Expose val last_name: String?,
  @SerializedName("profile_pic") @Expose val profile_pic: String?
)