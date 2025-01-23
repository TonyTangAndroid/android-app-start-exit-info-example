package com.tomas.repcik.appstartinfodemo.appinforepo


data class AppExitInfo(
  val exitReason: ExitReason, // reason, why the app was exited
  val exitImportance: ProcessImportance, // how important the app process was as point of exiting
  val description: String?, // text description what happened
  val timestamp: Long // timestamp of the process's death, in milliseconds since the epoch
)

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
}
