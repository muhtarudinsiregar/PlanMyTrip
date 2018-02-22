package com.example.ardin.planmytrip.application

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by ardin on 21/02/18.
 */
class SqliteExample : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}