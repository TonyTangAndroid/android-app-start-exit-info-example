package com.demo.core.app_start_up_info

import android.app.ApplicationStartInfo
import android.os.Build
import androidx.annotation.RequiresApi
import com.demo.core.app_start_up_info.model.LaunchMode
import com.demo.core.app_start_up_info.model.LaunchMode.LAUNCH_MODE_SINGLE_INSTANCE
import com.demo.core.app_start_up_info.model.LaunchMode.LAUNCH_MODE_SINGLE_INSTANCE_PER_TASK
import com.demo.core.app_start_up_info.model.LaunchMode.LAUNCH_MODE_SINGLE_TASK
import com.demo.core.app_start_up_info.model.LaunchMode.LAUNCH_MODE_SINGLE_TOP
import com.demo.core.app_start_up_info.model.LaunchMode.LAUNCH_MODE_STANDARD
import com.demo.core.app_start_up_info.model.LaunchMode.LAUNCH_MODE_UNKNOWN
import com.demo.core.app_start_up_info.model.StartReason
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_ALARM
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_BACKUP
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_BOOT_COMPLETE
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_BROADCAST
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_CONTENT_PROVIDER
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_JOB
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_LAUNCHER
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_LAUNCHER_RECENTS
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_OTHER
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_PUSH
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_SERVICE
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_START_ACTIVITY
import com.demo.core.app_start_up_info.model.StartReason.START_REASON_UNKNOWN
import com.demo.core.app_start_up_info.model.StartType
import com.demo.core.app_start_up_info.model.StartType.START_TYPE_COLD
import com.demo.core.app_start_up_info.model.StartType.START_TYPE_HOT
import com.demo.core.app_start_up_info.model.StartType.START_TYPE_UNSET
import com.demo.core.app_start_up_info.model.StartType.START_TYPE_WARM
import com.demo.core.app_start_up_info.model.StartupState
import com.demo.core.app_start_up_info.model.StartupState.STARTUP_STATE_ERROR
import com.demo.core.app_start_up_info.model.StartupState.STARTUP_STATE_FIRST_FRAME_DRAWN
import com.demo.core.app_start_up_info.model.StartupState.STARTUP_STATE_STARTED
import com.demo.core.app_start_up_info.model.StartupState.STARTUP_STATE_UNKNOWN

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
internal object AppStartInfoModelMapper {
  fun toAppLaunchMode(value: Int): LaunchMode {
    return when (value) {
      ApplicationStartInfo.LAUNCH_MODE_SINGLE_INSTANCE -> LAUNCH_MODE_SINGLE_INSTANCE
      ApplicationStartInfo.LAUNCH_MODE_SINGLE_INSTANCE_PER_TASK -> LAUNCH_MODE_SINGLE_INSTANCE_PER_TASK
      ApplicationStartInfo.LAUNCH_MODE_SINGLE_TASK -> LAUNCH_MODE_SINGLE_TASK
      ApplicationStartInfo.LAUNCH_MODE_SINGLE_TOP -> LAUNCH_MODE_SINGLE_TOP
      ApplicationStartInfo.LAUNCH_MODE_STANDARD -> LAUNCH_MODE_STANDARD
      else -> LAUNCH_MODE_UNKNOWN
    }
  }

  fun toAppStartState(value: Int): StartupState {
    return when (value) {
      ApplicationStartInfo.STARTUP_STATE_ERROR -> STARTUP_STATE_ERROR
      ApplicationStartInfo.STARTUP_STATE_FIRST_FRAME_DRAWN -> STARTUP_STATE_FIRST_FRAME_DRAWN
      ApplicationStartInfo.STARTUP_STATE_STARTED -> STARTUP_STATE_STARTED
      else -> STARTUP_STATE_UNKNOWN
    }
  }

  fun toAppStartReason(value: Int): StartReason {
    return when (value) {
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
      else -> START_REASON_UNKNOWN
    }
  }

  fun toAppStartType(value: Int): StartType {
    return when (value) {
      ApplicationStartInfo.START_TYPE_COLD -> START_TYPE_COLD
      ApplicationStartInfo.START_TYPE_HOT -> START_TYPE_HOT
      ApplicationStartInfo.START_TYPE_UNSET -> START_TYPE_UNSET
      ApplicationStartInfo.START_TYPE_WARM -> START_TYPE_WARM
      else -> StartType.START_TYPE_UNKNOWN
    }
  }

}