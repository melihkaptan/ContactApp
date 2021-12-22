package com.melhkptn.contactapp.feature_contact.domain.usecase.base

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface BaseUseCase {

    interface RequestInteractor<params : Params, T : Any> :
        BaseUseCase {

        fun fetch(compositeDisposable: CompositeDisposable,
                  postParams: params,
                  onResponse : (T) -> Unit) : Disposable

        fun executeAsync(postParams: params): Single<T>
    }

    //marker class
    abstract class Params
}