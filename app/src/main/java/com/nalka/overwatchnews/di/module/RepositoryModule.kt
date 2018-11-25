package com.nalka.overwatchnews.di.module

import android.content.Context
import com.nalka.overwatchnews.di.scope.AppScope
import com.nalka.overwatchnews.model.db.Db
import com.nalka.overwatchnews.model.repo.DBRepo
import com.nalka.overwatchnews.model.repo.view.HeroRepo
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class RepositoryModule {

    @Provides
    @AppScope
    @Inject
    fun provideDBRepo(db: Db) = DBRepo(db)

    @Provides
    @AppScope
    @Inject
    fun provideHeroRepo(dbRepo: DBRepo) = HeroRepo(dbRepo)
}