package com.demo.core.app_start_up_info

import android.app.Application

class AppStartInfoApp : Application() {
  override fun onCreate() {
    println(" app_startup kicked off on preCreate : $this")
    super.onCreate()
    println(" app_startup kicked off on postCreate: $this")
  }
}