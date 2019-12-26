package com.itmoclimbing

import android.app.Application
import com.itmoclimbing.internal.di.DI
import toothpick.configuration.Configuration
import toothpick.ktp.KTP

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        KTP.setConfiguration((if (BuildConfig.DEBUG) Configuration.forDevelopment() else Configuration.forProduction()).preventMultipleRootScopes())
        DI.openRootScope()
        DI.getAppScope()
    }

}