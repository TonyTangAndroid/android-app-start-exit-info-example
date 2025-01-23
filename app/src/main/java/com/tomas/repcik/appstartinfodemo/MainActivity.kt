package com.tomas.repcik.appstartinfodemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tomas.repcik.appstartinfodemo.MainActivityComposeUI.composeContent
import com.tomas.repcik.appstartinfodemo.appinforepo.AppInfoRepo

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    val appInfoRepo = AppInfoRepo(this)
    setContent { composeContent(appInfoRepo) }
  }

}