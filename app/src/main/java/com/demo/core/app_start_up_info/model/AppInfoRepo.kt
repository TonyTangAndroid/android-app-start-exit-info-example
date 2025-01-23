package com.demo.core.app_start_up_info.model

import android.content.Context
import java.util.concurrent.Executor

interface AppInfoRepo {

  fun addStartInfoListener(executor: Executor, callback: (AppInfoModel) -> Unit)
  fun preOnCreate()
  fun postOnCreate()

  companion object {
    fun create(context: Context): AppInfoRepo {
      return StubAppInfoRepo
    }
  }

}