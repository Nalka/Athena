package com.nalka.overwatchnews.di.module

import android.app.Application
import com.nalka.overwatchnews.App
import com.nalka.overwatchnews.di.scope.AppScope
import com.nalka.overwatchnews.model.db.Db
import dagger.Module
import dagger.Provides

@Module
class AppModule (
    val application: Application
) {
    @Provides
    @AppScope
    fun provideApplication() : Application = application


    @Provides
    @AppScope
    fun provideDatabase(app: Application) = Db.getInstance(app)
}