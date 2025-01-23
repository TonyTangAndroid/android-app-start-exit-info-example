package com.tomas.repcik.appstartinfodemo

import com.demo.core.app_start_up_info.AppStartInfoBean
import com.tomas.repcik.appstartinfodemo.appinforepo.AppExitInfo

data class AppInfoModel(val appStartUpInfoList: List<AppStartInfoBean>, val appExitInfoList: List<AppExitInfo>)
