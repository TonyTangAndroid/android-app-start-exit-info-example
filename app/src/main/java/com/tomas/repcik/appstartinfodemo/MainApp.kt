package com.tomas.repcik.appstartinfodemo

import android.app.Application
import com.demo.core.app_start_up_info.model.AppInfoRepo

class MainApp : Application() {

  private lateinit var repo :AppInfoRepo

  override fun onCreate() {
    super.onCreate()
    repo =AppInfoRepo.create(this)
  }

  fun repo() : AppInfoRepo {
    return repo
  }

}