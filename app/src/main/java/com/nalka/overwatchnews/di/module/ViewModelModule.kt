package com.nalka.overwatchnews.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nalka.overwatchnews.di.ViewModelFactory
import com.nalka.overwatchnews.di.ViewModelKey
import com.nalka.overwatchnews.di.scope.AppScope
import com.nalka.overwatchnews.screens.heroes.detail.HeroDetailsFragmentVM

import com.nalka.overwatchnews.screens.heroes.list.HeroListFragmentVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @AppScope
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @AppScope
    @Binds
    @IntoMap
    @ViewModelKey(HeroListFragmentVM::class)
    internal abstract fun bindHeroListFragmentVM(heroListFragmentVM: HeroListFragmentVM): ViewModel

    @AppScope
    @Binds
    @IntoMap
    @ViewModelKey(HeroDetailsFragmentVM::class)
    internal abstract fun bindHeroDetailsFragmentVM(heroListFragmentVM: HeroDetailsFragmentVM): ViewModel
}