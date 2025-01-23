package com.demo.core.app_start_up_info

import android.app.ApplicationExitInfo
import android.app.ApplicationStartInfo
import com.tomas.repcik.appstartinfodemo.appinforepo.AppExitInfo
import com.tomas.repcik.appstartinfodemo.appinforepo.AppExitInfoEnumsMapper


object AppStartInfoMapper {

   fun mapStartInfo(startInfo: ApplicationStartInfo): AppStartInfoBean {
    val startType = AppStartInfoModelMapper.toAppStartType(startInfo.startType)
    val startReason = AppStartInfoModelMapper.toAppStartReason(startInfo.reason)
    val startUpState = AppStartInfoModelMapper.toAppStartState(startInfo.startupState)
    val launchMode = AppStartInfoModelMapper.toAppLaunchMode(startInfo.launchMode)
    val startTimestamp = AppStartInfoModelMapper.toStartupTimestamps(startInfo.startupTimestamps)
    val wasForceStopped = startInfo.wasForceStopped()
    val startIntent = startInfo.intent
    return AppStartInfoBean(
      startType,
      startUpState,
      startReason,
      launchMode,
      startTimestamp,
      wasForceStopped,
      startIntent
    )
  }

   fun mapExitInfo(exitInfo: ApplicationExitInfo): AppExitInfo {
    val exitReason = AppExitInfoEnumsMapper.toExitReason(exitInfo.reason)
    val importance = AppExitInfoEnumsMapper.toProcessImportance(exitInfo.importance)
    val description = exitInfo.description
    val timestamp = exitInfo.timestamp
    return AppExitInfo(exitReason, importance, description, timestamp)
  }

}