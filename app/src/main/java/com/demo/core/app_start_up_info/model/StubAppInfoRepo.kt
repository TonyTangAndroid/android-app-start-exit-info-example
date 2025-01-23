package com.demo.core.app_start_up_info.model

import java.util.concurrent.Executor

object StubAppInfoRepo : AppInfoRepo {

  override fun addStartInfoListener(executor: Executor, callback: (AppStartUpInfoModel) -> Unit) {
    //no-op
  }

  override fun preOnCreate() {
    //no-op
  }

  override fun postOnCreate() {
    //no-op
  }
}