package com.tomas.repcik.appstartinfodemo.appinforepo


data class AppStartInfo(
    val startType: StartType, // what is the starting point, e.g. hot/cold start
    val startupState: StartupState, // what stage of starting of the app occured, e.g. started/first image rendered
    val startReason: StartReason, // why the app was started
    val launchMode: LaunchMode, // e.g. SINGLE_TASK, SINGLE_TOP
    val timestamps: StartupTimestamps, // timestamps of the events
    val wasForceStopped: Boolean // if the app was forced to quit during startup
)