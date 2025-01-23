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
import com.demo.core.app_start_up_info.AppStartInfoBean
import com.tomas.repcik.appstartinfodemo.appinforepo.AppExitInfo
import com.tomas.repcik.appstartinfodemo.ui.theme.AppStartInfoDemoTheme

object MainActivityComposeUI {

  @Composable
  fun ComposeUI(model: AppInfoModel) {
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
    model: AppInfoModel,
    modifier: Modifier
  ) {
    Column(
      modifier = modifier
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
      Text("Start history", style = MaterialTheme.typography.bodyLarge)
      model.appStartUpInfoList.forEach { startInfo -> StartInfoComp(startInfo) }

      Text("Exit history", style = MaterialTheme.typography.bodyLarge)
      model.appExitInfoList.forEach { exitInfo -> ExitInfoComp(exitInfo) }
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

  @Composable
  fun ExitInfoComp(exitInfo: AppExitInfo) {
    Card(modifier = Modifier.padding(8.dp)) {
      Column(modifier = Modifier.padding(8.dp)) {
        Text(exitInfo.exitReason.name, style = MaterialTheme.typography.bodyMedium)
        Text(exitInfo.exitImportance.name, style = MaterialTheme.typography.bodyMedium)
        exitInfo.description?.let { Text(it, style = MaterialTheme.typography.bodyMedium) }
      }
    }
  }
}
