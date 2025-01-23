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
    val startInfos = activityManager.getHistoricalProcessStartReasons(1)
    val startInfo = startInfos.firstOrNull() ?: return null
    return mapStartInfo(startInfo)
  }

  fun getStartInfoHistory(maxNum: Int): List<AppStartInfoBean> {
    val startInfos = activityManager.getHistoricalProcessStartReasons(maxNum)
    return startInfos.map { mapStartInfo(it) }
  }

  fun getLatestExitInfo(pid: Int = 0): AppExitInfo? {
    val exitInfos = activityManager.getHistoricalProcessExitReasons(packageName, pid, 1)
    val exitInfo = exitInfos.firstOrNull() ?: return null
    return mapExitInfo(exitInfo)
  }

  fun getExitInfoHistory(maxNum: Int, pid: Int = 0): List<AppExitInfo> {
    val exitInfos = activityManager.getHistoricalProcessExitReasons(packageName, pid, maxNum)
    return exitInfos.map { mapExitInfo(it) }
  }


  private fun mapStartInfo(startInfo: ApplicationStartInfo): AppStartInfoBean {
    return AppStartInfoMapper.mapStartInfo(startInfo)
  }

  private fun mapExitInfo(exitInfo: ApplicationExitInfo): AppExitInfo {
    return AppStartInfoMapper.mapExitInfo(exitInfo)
  }

}