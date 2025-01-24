package com.tomas.repcik.appstartinfodemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class DeviceBootReceiver : BroadcastReceiver() {

  override fun onReceive(context: Context, intent: Intent) {
    if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
      println("app_startup Device boot completed. Starting app.")
    }
  }
}