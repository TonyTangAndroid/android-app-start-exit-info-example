package com.tomas.repcik.appstartinfodemo.appinforepo

import android.app.ActivityManager
import android.app.ApplicationExitInfo
import android.os.Build
import androidx.annotation.RequiresApi
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_ANR
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_CRASH
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_CRASH_NATIVE
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_DEPENDENCY_DIED
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_EXCESSIVE_RESOURCE_USAGE
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_EXIT_SELF
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_FREEZER
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_INITIALIZATION_FAILURE
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_LOW_MEMORY
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_OTHER
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_PACKAGE_STATE_CHANGE
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_PACKAGE_UPDATED
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_PERMISSION_CHANGE
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_SIGNALED
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_UNKNOWN
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_USER_REQUESTED
import com.tomas.repcik.appstartinfodemo.appinforepo.ExitReason.REASON_USER_STOPPED
import com.tomas.repcik.appstartinfodemo.appinforepo.ProcessImportance.IMPORTANCE_CACHED
import com.tomas.repcik.appstartinfodemo.appinforepo.ProcessImportance.IMPORTANCE_CANT_SAVE_STATE
import com.tomas.repcik.appstartinfodemo.appinforepo.ProcessImportance.IMPORTANCE_FOREGROUND
import com.tomas.repcik.appstartinfodemo.appinforepo.ProcessImportance.IMPORTANCE_FOREGROUND_SERVICE
import com.tomas.repcik.appstartinfodemo.appinforepo.ProcessImportance.IMPORTANCE_GONE
import com.tomas.repcik.appstartinfodemo.appinforepo.ProcessImportance.IMPORTANCE_PERCEPTIBLE
import com.tomas.repcik.appstartinfodemo.appinforepo.ProcessImportance.IMPORTANCE_SERVICE
import com.tomas.repcik.appstartinfodemo.appinforepo.ProcessImportance.IMPORTANCE_TOP_SLEEPING
import com.tomas.repcik.appstartinfodemo.appinforepo.ProcessImportance.IMPORTANCE_VISIBLE


object AppExitInfoEnumsMapper {

  @RequiresApi(Build.VERSION_CODES.R)
  fun mapExitInfo(exitInfo: ApplicationExitInfo): AppExitInfo {
    val exitReason = toExitReason(exitInfo.reason)
    val importance = toProcessImportance(exitInfo.importance)
    val description = exitInfo.description
    val timestamp = exitInfo.timestamp
    return AppExitInfo(exitReason, importance, description, timestamp)
  }

  private fun toExitReason(value: Int): ExitReason {
    return when (value) {
      ApplicationExitInfo.REASON_ANR -> REASON_ANR
      ApplicationExitInfo.REASON_CRASH -> REASON_CRASH
      ApplicationExitInfo.REASON_CRASH_NATIVE -> REASON_CRASH_NATIVE
      ApplicationExitInfo.REASON_DEPENDENCY_DIED -> REASON_DEPENDENCY_DIED
      ApplicationExitInfo.REASON_EXCESSIVE_RESOURCE_USAGE -> REASON_EXCESSIVE_RESOURCE_USAGE
      ApplicationExitInfo.REASON_EXIT_SELF -> REASON_EXIT_SELF
      ApplicationExitInfo.REASON_FREEZER -> REASON_FREEZER
      ApplicationExitInfo.REASON_INITIALIZATION_FAILURE -> REASON_INITIALIZATION_FAILURE
      ApplicationExitInfo.REASON_LOW_MEMORY -> REASON_LOW_MEMORY
      ApplicationExitInfo.REASON_OTHER -> REASON_OTHER
      ApplicationExitInfo.REASON_PACKAGE_STATE_CHANGE -> REASON_PACKAGE_STATE_CHANGE
      ApplicationExitInfo.REASON_PACKAGE_UPDATED -> REASON_PACKAGE_UPDATED
      ApplicationExitInfo.REASON_PERMISSION_CHANGE -> REASON_PERMISSION_CHANGE
      ApplicationExitInfo.REASON_SIGNALED -> REASON_SIGNALED
      ApplicationExitInfo.REASON_UNKNOWN -> REASON_UNKNOWN
      ApplicationExitInfo.REASON_USER_REQUESTED -> REASON_USER_REQUESTED
      ApplicationExitInfo.REASON_USER_STOPPED -> REASON_USER_STOPPED
      else -> throw IllegalArgumentException("Unknown exit reason value: $value")
    }
  }


  private fun toProcessImportance(value: Int): ProcessImportance {
    return when (value) {
      ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND -> IMPORTANCE_FOREGROUND
      ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND_SERVICE -> IMPORTANCE_FOREGROUND_SERVICE
      ActivityManager.RunningAppProcessInfo.IMPORTANCE_TOP_SLEEPING -> IMPORTANCE_TOP_SLEEPING
      ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE -> IMPORTANCE_VISIBLE
      ActivityManager.RunningAppProcessInfo.IMPORTANCE_PERCEPTIBLE -> IMPORTANCE_PERCEPTIBLE
      ActivityManager.RunningAppProcessInfo.IMPORTANCE_CANT_SAVE_STATE -> IMPORTANCE_CANT_SAVE_STATE
      ActivityManager.RunningAppProcessInfo.IMPORTANCE_SERVICE -> IMPORTANCE_SERVICE
      ActivityManager.RunningAppProcessInfo.IMPORTANCE_CACHED -> IMPORTANCE_CACHED
      ActivityManager.RunningAppProcessInfo.IMPORTANCE_GONE -> IMPORTANCE_GONE
      else -> throw IllegalArgumentException("Unknown process importance value: $value")
    }
  }
}
