package com.demo.core.app_start_up_info

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.demo.core.app_start_up_info.model.AppStartUpInfoModel
import com.demo.core.app_start_up_info.model.AppInfoRepo
import java.util.concurrent.Executor

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
class ProdAppInfoRepo(context: Context) : AppInfoRepo {

  private val activityManager: ActivityManager =
    context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

  override  fun postOnCreate() {
    Thread.sleep(10)
    addStartupCheckPoint(StartupTimestampsMapper.KEY_POST_ON_CREATE)
  }

  override fun preOnCreate() {
    addStartupCheckPoint(StartupTimestampsMapper.KEY_PRE_ON_CREATE)
  }

  private fun addStartupCheckPoint(key: Int) {
    activityManager.addStartInfoTimestamp(key, System.currentTimeMillis())
  }

  override fun addStartInfoListener(executor: Executor, callback: (AppStartUpInfoModel) -> Unit) {
    activityManager.addApplicationStartInfoCompletionListener(executor) {
      callback(AppStartUpInfoModel(listOf(AppStartInfoMapper.mapStartInfo(it))))
    }
  }


}