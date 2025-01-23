package com.tomas.repcik.appstartinfodemo

import android.app.ApplicationStartInfo
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import com.demo.core.app_start_up_info.AppStartInfoMapper
import com.tomas.repcik.appstartinfodemo.MainActivityComposeUI.ComposeUI
import com.tomas.repcik.appstartinfodemo.appinforepo.AppInfoRepo
import java.util.concurrent.Executors

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
      loadStartUpModel()
    }
  }

  @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
  private fun loadStartUpModel() {
    AppInfoRepo(application).addStartInfoListener(Executors.newSingleThreadExecutor(), ::onLatestAppStartInfoReady)
  }

  @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
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