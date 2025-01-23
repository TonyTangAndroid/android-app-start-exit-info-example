package com.tomas.repcik.appstartinfodemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.demo.core.app_start_up_info.model.AppStartInfoBean
import com.demo.core.app_start_up_info.model.AppStartInfoBeanStream
import com.tomas.repcik.appstartinfodemo.MainActivityComposeUI.ComposeUI
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider.from
import com.uber.autodispose.autoDispose
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    loadStartUpModel(AppStartInfoBeanStream())
  }

  private fun loadStartUpModel(stream: AppStartInfoBeanStream) {
    stream.streaming().observeOn(AndroidSchedulers.mainThread())
      .autoDispose(from(this))
      .subscribe(::renderModel)
    AppStartUpInfoObservingWorker(application, stream).observeData()
  }

  private fun renderModel(model: AppStartInfoBean) {
    setContent { ComposeUI(model) }
  }

}