package com.demo.core.app_start_up_info

import android.app.ActivityManager
import android.app.ApplicationStartInfo
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.concurrent.Executor

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)

class AppInfoRepo(context: Context) {

  private val activityManager: ActivityManager =
    context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

  fun postOnCreate() {
    Thread.sleep(10)
    addStartupCheckPoint(StartupTimestampsMapper.KEY_POST_ON_CREATE)
  }

  fun preOnCreate() {
    addStartupCheckPoint(StartupTimestampsMapper.KEY_PRE_ON_CREATE)
  }

  private fun addStartupCheckPoint(key: Int) {
    addCustomStartTimeStamp(key, System.currentTimeMillis())
  }

  fun addStartInfoListener(executor: Executor, callback: (ApplicationStartInfo) -> Unit) {
    activityManager.addApplicationStartInfoCompletionListener(executor, callback)
  }

  fun addCustomStartTimeStamp(key: Int, timestamp: Long) {
    activityManager.addStartInfoTimestamp(key, timestamp)
  }


}