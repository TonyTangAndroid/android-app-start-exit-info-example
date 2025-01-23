package com.demo.core.app_start_up_info.model

import android.content.Context
import android.os.Build
import com.demo.core.app_start_up_info.ProdAppInfoRepo
import java.util.concurrent.Executor

interface AppInfoRepo {

  fun addStartInfoListener(executor: Executor, callback: (AppInfoModel) -> Unit)
  fun preOnCreate()
  fun postOnCreate()

  companion object {
    fun create(context: Context): AppInfoRepo {
      return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
        ProdAppInfoRepo(context)
      } else {
        StubAppInfoRepo
      }
    }
  }

}