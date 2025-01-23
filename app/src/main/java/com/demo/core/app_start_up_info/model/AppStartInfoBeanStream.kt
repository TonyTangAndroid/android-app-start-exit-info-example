package com.demo.core.app_start_up_info.model

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class AppStartInfoBeanStream {
  private val listeners: BehaviorSubject<AppStartInfoBean> = BehaviorSubject.create()

  fun accept(appStartInfoBean: AppStartInfoBean) {
    listeners.onNext(appStartInfoBean)
  }

  fun streaming(): Observable<AppStartInfoBean> {
    return listeners.hide()
  }
}