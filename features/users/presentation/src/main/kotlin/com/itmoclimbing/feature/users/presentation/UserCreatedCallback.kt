package com.itmoclimbing.feature.users.presentation

import io.reactivex.subjects.PublishSubject
import toothpick.InjectConstructor

@InjectConstructor
class UserCreatedCallback {

    val result = PublishSubject.create<Boolean>()

}