package com.demo.core.app_start_up_info

import android.app.ApplicationStartInfo
import android.os.Build
import androidx.annotation.RequiresApi


object StartupTimestampsMapper {

  @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
  fun toStartupTimestamps(timestampMap: Map<Int, Long>): StartupTimestamps {
    return StartupTimestamps(
      applicationOnCreate = timestampMap[ApplicationStartInfo.START_TIMESTAMP_APPLICATION_ONCREATE],
      bindApplication = timestampMap[ApplicationStartInfo.START_TIMESTAMP_BIND_APPLICATION],
      firstFrame = timestampMap[ApplicationStartInfo.START_TIMESTAMP_FIRST_FRAME],
      fork = timestampMap[ApplicationStartInfo.START_TIMESTAMP_FORK],
      fullyDrawn = timestampMap[ApplicationStartInfo.START_TIMESTAMP_FULLY_DRAWN],
      initialRenderThreadFrame = timestampMap[ApplicationStartInfo.START_TIMESTAMP_INITIAL_RENDERTHREAD_FRAME],
      launch = timestampMap[ApplicationStartInfo.START_TIMESTAMP_LAUNCH],
      preOnCreate = timestampMap[StartupTimestamps.KEY_PRE_ON_CREATE],
      postOnCreate = timestampMap[StartupTimestamps.KEY_POST_ON_CREATE],
      reservedRangeSystem = timestampMap[ApplicationStartInfo.START_TIMESTAMP_RESERVED_RANGE_SYSTEM],
      surfaceFlingerCompositionComplete = timestampMap[ApplicationStartInfo.START_TIMESTAMP_SURFACEFLINGER_COMPOSITION_COMPLETE]
    )
  }

}