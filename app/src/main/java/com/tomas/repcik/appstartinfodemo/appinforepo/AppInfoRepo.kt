package com.tomas.repcik.appstartinfodemo.appinforepo

import android.app.ActivityManager
import android.app.ApplicationStartInfo
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.concurrent.Executor


class AppInfoRepo(context: Context) {

  private val activityManager: ActivityManager =
    context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager


  @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
  fun addStartInfoListener(executor: Executor, callback: (ApplicationStartInfo) -> Unit) {
    activityManager.addApplicationStartInfoCompletionListener(executor, callback)
  }

  fun addCustomStartTimeStamp(key: Int, timestamp: Long) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
      activityManager.addStartInfoTimestamp(key, timestamp)
    }
  }


}