package com.mkeeda.runchdomain.extension

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.disposed(by: CompositeDisposable) {
    by.add(this)
}
