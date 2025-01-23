package com.demo.core.app_start_up_info

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.demo.core.app_start_up_info.model.AppInfoRepo
import com.demo.core.app_start_up_info.model.AppStartInfoBean
import java.util.concurrent.Executor

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
class ProdAppInfoRepo(context: Context) : AppInfoRepo {

  private val activityManager: ActivityManager =
    context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

  override fun addStartInfoListener(executor: Executor, callback: (AppStartInfoBean) -> Unit) {
    activityManager.addApplicationStartInfoCompletionListener(executor) {
      callback(AppStartInfoMapper.mapStartInfo(it))
    }
  }


}