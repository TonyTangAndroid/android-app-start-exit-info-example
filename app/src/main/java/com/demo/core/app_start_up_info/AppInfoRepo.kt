package com.demo.core.app_start_up_info

import android.app.ActivityManager
import android.app.ApplicationStartInfo
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.demo.core.app_start_up_info.model.AppInfoModel
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
    activityManager.addStartInfoTimestamp(key, System.currentTimeMillis())
  }

  fun addStartInfoListener(executor: Executor, callback: (AppInfoModel) -> Unit) {
    activityManager.addApplicationStartInfoCompletionListener(executor){
      callback(AppInfoModel(listOf(AppStartInfoMapper.mapStartInfo(it))))
    }
  }


}