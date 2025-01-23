package com.tomas.repcik.appstartinfodemo.appinforepo

import android.app.ActivityManager
import android.app.ApplicationExitInfo
import android.app.ApplicationStartInfo
import android.content.Context
import java.util.concurrent.Executor


class AppInfoRepo(context: Context) {

    private val activityManager: ActivityManager =
        context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    private val packageName = context.packageName

    fun addStartInfoListener(executor: Executor, callback: (ApplicationStartInfo) -> Unit) =
        activityManager.addApplicationStartInfoCompletionListener(executor, callback)

    fun addCustomStartTimeStamp(key: Int, timestamp: Long) =
        activityManager.addStartInfoTimestamp(key, timestamp)

    fun getLatestStartInfo(): AppStartInfo? {
        val startInfos = activityManager.getHistoricalProcessStartReasons(1)
        val startInfo = startInfos.firstOrNull() ?: return null
        return mapStartInfo(startInfo)
    }

    fun getStartInfoHistory(maxNum: Int): List<AppStartInfo> {
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


    private fun mapStartInfo(startInfo: ApplicationStartInfo): AppStartInfo {
        val startType = StartType.fromValue(startInfo.startType)
        val startReason = StartReason.fromValue(startInfo.reason)
        val startUpState = StartupState.fromValue(startInfo.startupState)
        val launchMode = LaunchMode.fromValue(startInfo.launchMode)
        val startTimestamp = StartupTimestamps.fromMap(startInfo.startupTimestamps)
        val wasForceStopped = startInfo.wasForceStopped()
        val startIntent = startInfo.intent
        return AppStartInfo(
            startType,
            startUpState,
            startReason,
            launchMode,
            startTimestamp,
            wasForceStopped,
            startIntent
        )
    }

    private fun mapExitInfo(exitInfo: ApplicationExitInfo): AppExitInfo {
        val exitReason = AppExitInfoEnumsMapper.toExitReason(exitInfo.reason)
        val importance = AppExitInfoEnumsMapper.toProcessImportance(exitInfo.importance)
        val description = exitInfo.description
        val timestamp = exitInfo.timestamp
        return AppExitInfo(exitReason, importance, description, timestamp)
    }

}