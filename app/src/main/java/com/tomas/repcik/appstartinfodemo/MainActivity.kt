package com.tomas.repcik.appstartinfodemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import com.tomas.repcik.appstartinfodemo.appinforepo.AppExitInfo
import com.tomas.repcik.appstartinfodemo.appinforepo.AppInfoRepo
import com.demo.core.app_start_up_info.AppStartInfoBean
import com.tomas.repcik.appstartinfodemo.ui.theme.AppStartInfoDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val appInfoRepo = AppInfoRepo(this)
        setContent {
            AppStartInfoDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StartAndExitInfo(
                        appInfoRepo.getStartInfoHistory(1),
                        appInfoRepo.getExitInfoHistory(1),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StartAndExitInfo(
    startInfoHistory: List<AppStartInfoBean>,
    exitInfoHistory: List<AppExitInfo>,
    modifier: Modifier
) {
    Column(modifier = modifier.padding(16.dp).verticalScroll(rememberScrollState())) {
        Text("Start history", style = MaterialTheme.typography.bodyLarge)
        startInfoHistory.forEach { startInfo -> StartInfoComp(startInfo) }

        Text("Exit history", style = MaterialTheme.typography.bodyLarge)
        exitInfoHistory.forEach { exitInfo -> ExitInfoComp(exitInfo) }
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