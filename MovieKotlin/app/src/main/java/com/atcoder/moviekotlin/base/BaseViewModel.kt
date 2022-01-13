package com.atcoder.moviekotlin.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.atcoder.moviekotlin.util.DisposableManager
import io.reactivex.disposables.Disposable

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    protected open fun addDisposable(disposable: Disposable) {
        DisposableManager.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        DisposableManager.dispose()
    }
}