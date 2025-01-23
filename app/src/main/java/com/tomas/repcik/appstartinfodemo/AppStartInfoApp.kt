package com.tomas.repcik.appstartinfodemo

import android.app.Application
import android.os.Build
import com.demo.core.app_start_up_info.AppInfoRepo

class AppStartInfoApp : Application() {
  override fun onCreate() {
    preOnCreate()
    super.onCreate()
    postOnCreate()
  }

  private fun postOnCreate() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
      AppInfoRepo(this).postOnCreate()
    }
  }

  private fun preOnCreate() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
       AppInfoRepo(this).preOnCreate()
    }
  }

}