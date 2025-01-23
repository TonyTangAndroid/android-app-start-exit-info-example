package com.tomas.repcik.appstartinfodemo.appinforepo

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AppInfoRepoTest {

  @Test
  fun getLatestStartInfo() {
    assertThat(appContext()).isInstanceOf(Application::class.java)
  }

  private fun appContext(): Context {
    return ApplicationProvider.getApplicationContext()
  }
}