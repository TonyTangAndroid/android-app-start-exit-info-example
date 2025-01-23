package com.demo.core.app_start_up_info

import android.app.Application
import android.os.Build
import com.tomas.repcik.appstartinfodemo.appinforepo.AppInfoRepo

class AppStartInfoApp : Application() {
  override fun onCreate() {
    preOnCreate()
    super.onCreate()
    postOnCreate()
  }

  private fun postOnCreate() {
    Thread.sleep(10)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
      addStartupCheckPoint(StartupTimestampsMapper.KEY_POST_ON_CREATE)
    }
    println(" app_startup kicked off on postCreate: $this")
  }

  private fun preOnCreate() {
    println(" app_startup kicked off on preCreate : $this")
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
      addStartupCheckPoint(StartupTimestampsMapper.KEY_PRE_ON_CREATE)
    }
  }

  private fun addStartupCheckPoint(key: Int) {
    AppInfoRepo(this).addCustomStartTimeStamp(key, System.currentTimeMillis())
  }
}