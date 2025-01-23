package com.tomas.repcik.appstartinfodemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.demo.core.app_start_up_info.model.AppInfoRepo
import com.demo.core.app_start_up_info.model.AppInfoModel
import com.tomas.repcik.appstartinfodemo.MainActivityComposeUI.ComposeUI
import java.util.concurrent.Executors

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
      loadStartUpModel()
  }

  private fun loadStartUpModel() {
    AppInfoRepo.create(application).addStartInfoListener(Executors.newSingleThreadExecutor(), ::renderLatestModel)
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