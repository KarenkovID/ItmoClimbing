package com.itmoclimbing

import android.app.Application
import com.itmoclimbing.internal.di.DI

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DI.getAppScope()
    }

}