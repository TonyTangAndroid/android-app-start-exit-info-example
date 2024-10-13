package com.tomas.repcik.appstartinfodemo.appinforepo

import android.app.ActivityManager
import android.app.ApplicationExitInfo


enum class ExitReason {
    REASON_ANR,
    REASON_CRASH,
    REASON_CRASH_NATIVE,
    REASON_DEPENDENCY_DIED,
    REASON_EXCESSIVE_RESOURCE_USAGE,
    REASON_EXIT_SELF,
    REASON_FREEZER,
    REASON_INITIALIZATION_FAILURE,
    REASON_LOW_MEMORY,
    REASON_OTHER,
    REASON_PACKAGE_STATE_CHANGE,
    REASON_PACKAGE_UPDATED,
    REASON_PERMISSION_CHANGE,
    REASON_SIGNALED,
    REASON_UNKNOWN,
    REASON_USER_REQUESTED,
    REASON_USER_STOPPED;

    companion object {
        fun fromValue(value: Int): ExitReason = when (value) {
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
}

enum class ProcessImportance {
    IMPORTANCE_FOREGROUND,
    IMPORTANCE_FOREGROUND_SERVICE,
    IMPORTANCE_TOP_SLEEPING,
    IMPORTANCE_VISIBLE,
    IMPORTANCE_PERCEPTIBLE,
    IMPORTANCE_CANT_SAVE_STATE,
    IMPORTANCE_SERVICE,
    IMPORTANCE_CACHED,
    IMPORTANCE_GONE;

    companion object {
        fun fromValue(value: Int): ProcessImportance = when (value) {
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
