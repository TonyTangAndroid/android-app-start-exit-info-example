package com.tomas.repcik.appstartinfodemo.appinforepo

import android.app.ApplicationStartInfo

enum class LaunchMode {
    LAUNCH_MODE_SINGLE_INSTANCE,
    LAUNCH_MODE_SINGLE_INSTANCE_PER_TASK,
    LAUNCH_MODE_SINGLE_TASK,
    LAUNCH_MODE_SINGLE_TOP,
    LAUNCH_MODE_STANDARD;

    companion object {
        fun fromValue(value: Int): LaunchMode = when (value) {
            ApplicationStartInfo.LAUNCH_MODE_SINGLE_INSTANCE -> LAUNCH_MODE_SINGLE_INSTANCE
            ApplicationStartInfo.LAUNCH_MODE_SINGLE_INSTANCE_PER_TASK -> LAUNCH_MODE_SINGLE_INSTANCE_PER_TASK
            ApplicationStartInfo.LAUNCH_MODE_SINGLE_TASK -> LAUNCH_MODE_SINGLE_TASK
            ApplicationStartInfo.LAUNCH_MODE_SINGLE_TOP -> LAUNCH_MODE_SINGLE_TOP
            ApplicationStartInfo.LAUNCH_MODE_STANDARD -> LAUNCH_MODE_STANDARD
            else -> throw IllegalArgumentException("Unknown launch mode value: $value")
        }
    }
}

enum class StartupState {
    STARTUP_STATE_ERROR,
    STARTUP_STATE_FIRST_FRAME_DRAWN,
    STARTUP_STATE_STARTED;

    companion object {
        fun fromValue(value: Int): StartupState = when (value) {
            ApplicationStartInfo.STARTUP_STATE_ERROR -> STARTUP_STATE_ERROR
            ApplicationStartInfo.STARTUP_STATE_FIRST_FRAME_DRAWN -> STARTUP_STATE_FIRST_FRAME_DRAWN
            ApplicationStartInfo.STARTUP_STATE_STARTED -> STARTUP_STATE_STARTED
            else -> throw IllegalArgumentException("Unknown startup state value: $value")
        }
    }
}

enum class StartReason {
    START_REASON_ALARM,
    START_REASON_BACKUP,
    START_REASON_BOOT_COMPLETE,
    START_REASON_BROADCAST,
    START_REASON_CONTENT_PROVIDER,
    START_REASON_JOB,
    START_REASON_LAUNCHER,
    START_REASON_LAUNCHER_RECENTS,
    START_REASON_OTHER,
    START_REASON_PUSH,
    START_REASON_SERVICE,
    START_REASON_START_ACTIVITY;

    companion object {
        fun fromValue(value: Int): StartReason = when (value) {
            ApplicationStartInfo.START_REASON_ALARM -> START_REASON_ALARM
            ApplicationStartInfo.START_REASON_BACKUP -> START_REASON_BACKUP
            ApplicationStartInfo.START_REASON_BOOT_COMPLETE -> START_REASON_BOOT_COMPLETE
            ApplicationStartInfo.START_REASON_BROADCAST -> START_REASON_BROADCAST
            ApplicationStartInfo.START_REASON_CONTENT_PROVIDER -> START_REASON_CONTENT_PROVIDER
            ApplicationStartInfo.START_REASON_JOB -> START_REASON_JOB
            ApplicationStartInfo.START_REASON_LAUNCHER -> START_REASON_LAUNCHER
            ApplicationStartInfo.START_REASON_LAUNCHER_RECENTS -> START_REASON_LAUNCHER_RECENTS
            ApplicationStartInfo.START_REASON_OTHER -> START_REASON_OTHER
            ApplicationStartInfo.START_REASON_PUSH -> START_REASON_PUSH
            ApplicationStartInfo.START_REASON_SERVICE -> START_REASON_SERVICE
            ApplicationStartInfo.START_REASON_START_ACTIVITY -> START_REASON_START_ACTIVITY
            else -> throw IllegalArgumentException("Unknown start reason value: $value")
        }
    }
}

enum class StartType {
    START_TYPE_COLD,
    START_TYPE_HOT,
    START_TYPE_UNSET,
    START_TYPE_WARM;

    companion object {
        fun fromValue(value: Int): StartType = when (value) {
            ApplicationStartInfo.START_TYPE_COLD -> START_TYPE_COLD
            ApplicationStartInfo.START_TYPE_HOT -> START_TYPE_HOT
            ApplicationStartInfo.START_TYPE_UNSET -> START_TYPE_UNSET
            ApplicationStartInfo.START_TYPE_WARM -> START_TYPE_WARM
            else -> throw IllegalArgumentException("Unknown start type value: $value")
        }
    }
}

data class StartupTimestamps(
    val applicationOnCreate: Long? = null,
    val bindApplication: Long? = null,
    val firstFrame: Long? = null,
    val fork: Long? = null,
    val fullyDrawn: Long? = null,
    val initialRenderThreadFrame: Long? = null,
    val launch: Long? = null,
    val reservedRangeDeveloper: Long? = null,
    val reservedRangeDeveloperStart: Long? = null,
    val reservedRangeSystem: Long? = null,
    val surfaceFlingerCompositionComplete: Long? = null
) {
    companion object {
        fun fromMap(timestampMap: Map<Int, Long>): StartupTimestamps = StartupTimestamps(
            applicationOnCreate = timestampMap[ApplicationStartInfo.START_TIMESTAMP_APPLICATION_ONCREATE],
            bindApplication = timestampMap[ApplicationStartInfo.START_TIMESTAMP_BIND_APPLICATION],
            firstFrame = timestampMap[ApplicationStartInfo.START_TIMESTAMP_FIRST_FRAME],
            fork = timestampMap[ApplicationStartInfo.START_TIMESTAMP_FORK],
            fullyDrawn = timestampMap[ApplicationStartInfo.START_TIMESTAMP_FULLY_DRAWN],
            initialRenderThreadFrame = timestampMap[ApplicationStartInfo.START_TIMESTAMP_INITIAL_RENDERTHREAD_FRAME],
            launch = timestampMap[ApplicationStartInfo.START_TIMESTAMP_LAUNCH],
            reservedRangeDeveloper = timestampMap[ApplicationStartInfo.START_TIMESTAMP_RESERVED_RANGE_DEVELOPER],
            reservedRangeDeveloperStart = timestampMap[ApplicationStartInfo.START_TIMESTAMP_RESERVED_RANGE_DEVELOPER_START],
            reservedRangeSystem = timestampMap[ApplicationStartInfo.START_TIMESTAMP_RESERVED_RANGE_SYSTEM],
            surfaceFlingerCompositionComplete = timestampMap[ApplicationStartInfo.START_TIMESTAMP_SURFACEFLINGER_COMPOSITION_COMPLETE]
        )
    }
}