package com.tomas.repcik.appstartinfodemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tomas.repcik.appstartinfodemo.MainActivityComposeUI.ComposeUI
import com.tomas.repcik.appstartinfodemo.appinforepo.AppInfoRepo

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    renderModel(appInfoModel())
  }

  private fun renderModel(model: AppInfoModel) {
    setContent { ComposeUI(model) }
  }

   fun appInfoModel(): AppInfoModel {
    val appInfoRepo = AppInfoRepo(this)
    val model = AppInfoModel(appInfoRepo.getStartInfoHistory(1), appInfoRepo.getExitInfoHistory(1))
    return model
  }

}