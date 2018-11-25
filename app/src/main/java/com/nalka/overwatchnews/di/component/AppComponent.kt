package com.nalka.overwatchnews.di.component

import android.app.Application
import com.nalka.overwatchnews.di.ViewModelFactory
import com.nalka.overwatchnews.di.module.AppModule
import com.nalka.overwatchnews.di.module.RepositoryModule
import com.nalka.overwatchnews.di.module.ViewModelModule
import com.nalka.overwatchnews.di.scope.AppScope
import com.nalka.overwatchnews.model.repo.DBRepo
import com.nalka.overwatchnews.model.repo.view.HeroRepo
import com.nalka.overwatchnews.screens.base.BaseFragment
import dagger.Component

@AppScope
@Component(
    modules = [AppModule::class, RepositoryModule::class, ViewModelModule::class]
)
interface AppComponent {

    fun application() : Application

    fun heroRepo() : HeroRepo

    fun dbRepo() : DBRepo

    fun viewModelFactory() : ViewModelFactory

    fun inject(baseFragment: BaseFragment)


}