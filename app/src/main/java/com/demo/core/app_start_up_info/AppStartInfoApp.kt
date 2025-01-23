package com.demo.core.app_start_up_info

import android.app.Application
import com.tomas.repcik.appstartinfodemo.appinforepo.AppInfoRepo

class AppStartInfoApp : Application() {
  override fun onCreate() {
    preOnCreate()
    super.onCreate()
    postOnCreate()
  }

  private fun postOnCreate() {
    Thread.sleep(10)
    addStartupCheckPoint(StartupTimestampsMapper.KEY_POST_ON_CREATE)
    println(" app_startup kicked off on postCreate: $this")
  }

  private fun preOnCreate() {
    println(" app_startup kicked off on preCreate : $this")
    addStartupCheckPoint(StartupTimestampsMapper.KEY_PRE_ON_CREATE)
  }

  private fun addStartupCheckPoint(key: Int) {
    AppInfoRepo(this).addCustomStartTimeStamp(key, System.currentTimeMillis())
  }
}