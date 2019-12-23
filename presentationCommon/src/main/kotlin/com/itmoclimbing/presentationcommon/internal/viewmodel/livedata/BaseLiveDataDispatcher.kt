package com.itmoclimbing.internal.viewmodel.livedata

import androidx.lifecycle.MutableLiveData
import com.itmoclimbing.presentationcommon.internal.viewmodel.livedata.ContentEvent
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import com.itmoclimbing.presentationcommon.internal.viewmodel.livedata.Event

fun <T> Flowable<out T>.dispatchTo(liveData: MutableLiveData<ContentEvent<T>>): Disposable {
    liveData.value = ContentEvent.Loading(liveData.value?.data)
    return this
            .doOnNext { data -> liveData.value = ContentEvent.Success(data) }
            .doOnError { throwable -> liveData.value = ContentEvent.Error(throwable, liveData.value?.data) }
            .doOnComplete { liveData.value = ContentEvent.Complete(liveData.value?.data) }
            .subscribe()
}

fun <T> Observable<out T>.dispatchTo(liveData: MutableLiveData<ContentEvent<T>>): Disposable {
    liveData.value = ContentEvent.Loading(liveData.value?.data)
    return this
            .doOnNext { data -> liveData.value = ContentEvent.Success(data) }
            .doOnError { throwable -> liveData.value = ContentEvent.Error(throwable, liveData.value?.data) }
            .doOnComplete { liveData.value = ContentEvent.Complete(liveData.value?.data) }
            .subscribe()
}

fun <T> Single<out T>.dispatchTo(liveData: MutableLiveData<ContentEvent<T>>): Disposable {
    liveData.value = ContentEvent.Loading(liveData.value?.data)
    return this
            .doOnSuccess { data -> liveData.value = ContentEvent.Success(data) }
            .doOnError { throwable -> liveData.value = ContentEvent.Error(throwable, liveData.value?.data) }
            .subscribe()
}

fun <T> Maybe<out T>.dispatchTo(liveData: MutableLiveData<ContentEvent<T>>): Disposable {
    liveData.value = ContentEvent.Loading(liveData.value?.data)
    return this
            .doOnSuccess { data -> liveData.value = ContentEvent.Success(data) }
            .doOnComplete { liveData.value = null }
            .doOnError { throwable -> liveData.value = ContentEvent.Error(throwable, liveData.value?.data) }
            .subscribe()
}

fun <T> Completable.dispatchTo(liveData: MutableLiveData<Event>): Disposable {
    liveData.value = Event.Loading
    return this
            .doOnComplete { liveData.value = Event.Complete }
            .doOnError { throwable -> liveData.value = Event.Error(throwable) }
            .subscribe()
}