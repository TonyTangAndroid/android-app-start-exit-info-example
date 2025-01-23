package com.tomas.repcik.appstartinfodemo.appinforepo

import android.app.ActivityManager
import android.app.ApplicationStartInfo
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.demo.core.app_start_up_info.AppStartInfoBean
import com.demo.core.app_start_up_info.AppStartInfoMapper
import com.tomas.repcik.appstartinfodemo.AppInfoModel
import java.util.concurrent.Executor


class AppInfoRepo(context: Context) {

  private val activityManager: ActivityManager =
    context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
  private val packageName = context.packageName


  @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
  fun appInfoModel(): AppInfoModel {
    return AppInfoModel(getStartInfoHistory(1))
  }


  @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
  fun addStartInfoListener(executor: Executor, callback: (ApplicationStartInfo) -> Unit) {
    activityManager.addApplicationStartInfoCompletionListener(executor, callback)
  }

  fun addCustomStartTimeStamp(key: Int, timestamp: Long) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
      activityManager.addStartInfoTimestamp(key, timestamp)
    }
  }

  @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
  fun getLatestStartInfo(): AppStartInfoBean? {
    return activityManager.getHistoricalProcessStartReasons(1).firstOrNull()?.let { mapStartInfo(it) }

  }

  @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
  fun getStartInfoHistory(maxNum: Int): List<AppStartInfoBean> {
    return activityManager.getHistoricalProcessStartReasons(maxNum).map { mapStartInfo(it) }
  }

  @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
  private fun mapStartInfo(startInfo: ApplicationStartInfo): AppStartInfoBean {
    return AppStartInfoMapper.mapStartInfo(startInfo)
  }


}