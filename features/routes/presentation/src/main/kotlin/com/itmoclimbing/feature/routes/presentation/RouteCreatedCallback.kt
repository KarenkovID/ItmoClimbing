package com.itmoclimbing.feature.routes.presentation

import io.reactivex.subjects.PublishSubject
import toothpick.InjectConstructor

@InjectConstructor
class RouteCreatedCallback {

    val result = PublishSubject.create<Boolean>()

}