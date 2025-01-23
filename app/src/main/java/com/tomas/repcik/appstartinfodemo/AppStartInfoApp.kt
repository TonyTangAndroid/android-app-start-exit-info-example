package com.tomas.repcik.appstartinfodemo

import android.app.Application
import com.demo.core.app_start_up_info.model.AppInfoRepo

class AppStartInfoApp : Application() {
  override fun onCreate() {
    val repo = AppInfoRepo.create(this)
    repo.preOnCreate()
    super.onCreate()
    repo.postOnCreate()
  }

}