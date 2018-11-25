package com.nalka.overwatchnews.model.repo

import androidx.lifecycle.LiveData
import com.nalka.overwatchnews.model.db.Db
import com.nalka.overwatchnews.model.model.Hero
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DBRepo
    @Inject
    constructor(
        val db: Db
) {

    fun insertHeroList(heroList: List<Hero>) {
        Observable.fromCallable {
            val heroesFromDb = db.heroDao().getHeroListSync()
            if(heroesFromDb.isEmpty())
                db.heroDao().insertHeroes(heroList)
        }
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    fun getHeroListLight(): LiveData<List<Hero>> {
        return db.heroDao().getHeroListLight()
    }

    fun getHeroById(id: Long): LiveData<Hero> {
        return db.heroDao().getHeroById(id)
    }
}