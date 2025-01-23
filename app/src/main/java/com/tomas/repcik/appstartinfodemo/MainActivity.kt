package com.tomas.repcik.appstartinfodemo

import android.app.ApplicationStartInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.demo.core.app_start_up_info.AppStartInfoMapper
import com.tomas.repcik.appstartinfodemo.MainActivityComposeUI.ComposeUI
import com.tomas.repcik.appstartinfodemo.appinforepo.AppInfoRepo
import java.util.concurrent.Executors

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    AppInfoRepo(application).addStartInfoListener(Executors.newSingleThreadExecutor(), ::onLatestAppStartInfoReady)
  }

  fun onLatestAppStartInfoReady(info: ApplicationStartInfo) {
    renderLatestModel(AppInfoModel(listOf(AppStartInfoMapper.mapStartInfo(info))))
  }

  private fun renderLatestModel(latest: AppInfoModel) {
    runOnUiThread {
      renderModel(latest)
    }
  }

  private fun renderModel(model: AppInfoModel) {
    setContent { ComposeUI(model) }
  }

}