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
    renderModel(AppInfoRepo(this).appInfoModel())
  }

  private fun renderModel(model: AppInfoModel) {
    setContent { ComposeUI(model) }
  }

}