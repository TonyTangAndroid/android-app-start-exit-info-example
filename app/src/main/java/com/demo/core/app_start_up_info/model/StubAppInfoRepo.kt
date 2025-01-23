package com.demo.core.app_start_up_info.model

import io.reactivex.Observable

object StubAppInfoRepo : AppInfoRepo {
  override fun streaming(): Observable<AppStartInfoBean> {
    return Observable.empty()
  }
}