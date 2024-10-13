package com.tomas.repcik.appstartinfodemo.appinforepo


data class AppExitInfo(
    val exitReason: ExitReason, // reason, why the app was exited
    val exitImportance: ProcessImportance, // how important the app process was as point of exiting
    val description: String?, // text description what happened
    val timestamp: Long // timestamp of the process's death, in milliseconds since the epoch
)