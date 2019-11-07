package com.woua.mvvm.clean

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import javax.inject.Inject

class FooActivity : AppCompatActivity() {

  private var fooViewModel: FooViewModel? = null

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    fooViewModel = ViewModelProviders.of(this, viewModelFactory).get(FooViewModel::class.java)

    fooViewModel?.contactList()?.observe(this, Observer {
      if (it) {
        Toast.makeText(this, "Remote data fetched and same store in the DB", Toast.LENGTH_SHORT)
          .show()
      } else {
        Toast.makeText(this, "Unable to fecth data", Toast.LENGTH_SHORT).show()
      }
    })
  }

}
