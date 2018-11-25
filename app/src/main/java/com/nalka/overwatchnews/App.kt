package com.nalka.overwatchnews

import android.app.Application
import com.nalka.overwatchnews.di.component.AppComponent
import com.nalka.overwatchnews.di.component.DaggerAppComponent
import com.nalka.overwatchnews.di.module.AppModule
import com.nalka.overwatchnews.di.module.RepositoryModule

class App : Application() {

    lateinit var mAppComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        mAppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .repositoryModule(RepositoryModule())
            .build()

    }

}