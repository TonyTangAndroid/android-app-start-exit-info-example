package com.tomas.repcik.appstartinfodemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.demo.core.app_start_up_info.model.AppStartUpInfoModel
import com.demo.core.app_start_up_info.model.AppStartInfoBean
import com.tomas.repcik.appstartinfodemo.ui.theme.AppStartInfoDemoTheme

object MainActivityComposeUI {

  @Composable
  fun ComposeUI(model: AppStartUpInfoModel) {
    AppStartInfoDemoTheme {
      Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        StartAndExitInfo(
          model,
          modifier = Modifier.padding(innerPadding)
        )
      }
    }
  }

  @Composable
  fun StartAndExitInfo(
    model: AppStartUpInfoModel,
    modifier: Modifier
  ) {
    Column(
      modifier = modifier
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
      Text("Start history", style = MaterialTheme.typography.bodyLarge)
      model.list.forEach { startInfo -> StartInfoComp(startInfo) }
    }
  }
}

@Composable
fun StartInfoComp(startInfo: AppStartInfoBean) {
  Card(modifier = Modifier.padding(8.dp)) {
    Column(modifier = Modifier.padding(8.dp)) {
      Text(startInfo.startReason.name, style = MaterialTheme.typography.bodyMedium)
      Text(startInfo.startType.name, style = MaterialTheme.typography.bodyMedium)
      Text(startInfo.launchMode.name, style = MaterialTheme.typography.bodyMedium)
      Text(startInfo.startupState.name, style = MaterialTheme.typography.bodyMedium)
    }
  }
}

