package com.itmoclimbing

import android.app.Application
import com.itmoclimbing.di.DI

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DI.openAppScope()
    }

}