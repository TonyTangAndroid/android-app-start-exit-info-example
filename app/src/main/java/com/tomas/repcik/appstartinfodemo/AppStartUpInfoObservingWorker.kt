package com.tomas.repcik.appstartinfodemo

import android.app.Application
import com.demo.core.app_start_up_info.model.AppInfoRepo
import com.demo.core.app_start_up_info.model.AppStartInfoBeanStream
import java.util.concurrent.Executors

class AppStartUpInfoObservingWorker(
  private val application: Application,
  private val appStartInfoBeanStream: AppStartInfoBeanStream
) {

   fun observeData() {
    AppInfoRepo.create(application).addStartInfoListener(Executors.newSingleThreadExecutor(), appStartInfoBeanStream::accept)
  }
}