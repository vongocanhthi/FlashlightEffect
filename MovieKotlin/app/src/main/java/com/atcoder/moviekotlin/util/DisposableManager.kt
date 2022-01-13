package com.atcoder.moviekotlin.util

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

object DisposableManager {
    private var compositeDisposable: CompositeDisposable? = null
        get() {
            if (field == null || field!!.isDisposed) {
                field = CompositeDisposable()
            }
            return field
        }

    fun add(disposable: Disposable?) {
        compositeDisposable!!.add(disposable!!)
    }

    fun dispose() {
        compositeDisposable!!.dispose()
    }
}