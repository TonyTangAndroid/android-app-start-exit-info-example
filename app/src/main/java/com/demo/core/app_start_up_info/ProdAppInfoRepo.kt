package com.demo.core.app_start_up_info

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.demo.core.app_start_up_info.model.AppInfoRepo
import com.demo.core.app_start_up_info.model.AppStartInfoBean
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.Executors

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
class ProdAppInfoRepo(context: Context) : AppInfoRepo {
  private val behaviorSubject: BehaviorSubject<AppStartInfoBean> = BehaviorSubject.create()

  init {
    activityManager(context).addApplicationStartInfoCompletionListener(Executors.newSingleThreadExecutor()) {
      println("received app_startup ApplicationStartInfo: $it")
      behaviorSubject.onNext(AppStartInfoMapper.mapStartInfo(it))
    }
  }

  private fun activityManager(context: Context): ActivityManager {
    return context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
  }

  override fun streaming(): Observable<AppStartInfoBean> {
    return behaviorSubject.hide()
  }


}