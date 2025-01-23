package com.tomas.repcik.appstartinfodemo.appinforepo

import android.app.ActivityManager
import android.app.ApplicationExitInfo
import android.app.ApplicationStartInfo
import android.content.Context
import com.demo.core.app_start_up_info.AppStartInfoBean
import com.demo.core.app_start_up_info.AppStartInfoMapper
import java.util.concurrent.Executor


class AppInfoRepo(context: Context) {

  private val activityManager: ActivityManager =
    context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
  private val packageName = context.packageName

  fun addStartInfoListener(executor: Executor, callback: (ApplicationStartInfo) -> Unit) {
    activityManager.addApplicationStartInfoCompletionListener(executor, callback)
  }

  fun addCustomStartTimeStamp(key: Int, timestamp: Long) {
    activityManager.addStartInfoTimestamp(key, timestamp)
  }

  fun getLatestStartInfo(): AppStartInfoBean? {
    return activityManager.getHistoricalProcessStartReasons(1).firstOrNull()?.let { mapStartInfo(it) }
  }

  fun getStartInfoHistory(maxNum: Int): List<AppStartInfoBean> {
    return activityManager.getHistoricalProcessStartReasons(maxNum).map { mapStartInfo(it) }
  }

  fun getLatestExitInfo(): AppExitInfo? {
    return activityManager.getHistoricalProcessExitReasons(packageName, 0, 1).firstOrNull()?.let { mapExitInfo(it) }
  }

  fun getExitInfoHistory(maxNum: Int): List<AppExitInfo> {
    return activityManager.getHistoricalProcessExitReasons(packageName, 0, maxNum).map { mapExitInfo(it) }
  }

  private fun mapStartInfo(startInfo: ApplicationStartInfo): AppStartInfoBean {
    return AppStartInfoMapper.mapStartInfo(startInfo)
  }

  private fun mapExitInfo(exitInfo: ApplicationExitInfo): AppExitInfo {
    return AppStartInfoMapper.mapExitInfo(exitInfo)
  }

}