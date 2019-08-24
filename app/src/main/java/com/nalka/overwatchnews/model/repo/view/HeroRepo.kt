package com.nalka.overwatchnews.model.repo.view

import androidx.lifecycle.LiveData
import com.nalka.overwatchnews.model.model.Hero
import com.nalka.overwatchnews.model.repo.DBRepo
import com.nalka.overwatchnews.model.utils.*
import javax.inject.Inject

class HeroRepo
    @Inject
    constructor(
        private val dbRepo: DBRepo
    ) {

    fun getHeroList() : LiveData<List<Hero>> {
        return dbRepo.getHeroListLight()
    }

    fun getHeroDetails(id: Long): LiveData<Hero> {
        return dbRepo.getHeroById(id)
    }


    init { // NOTE!!
        // this is temporary; this data will eventually be requested from API; just needed some data to display
        // and to setup database calls
        val heroList = listOf(ana, ashe, baptiste, bastion, brigitte, doomfist, dva, genji, hanzo, junkrat, lucio,
            mccree, mei, mercy, moira, orisa, pharah, reaper, reinhardt, roadhog, sigma, soldier76, sombra, symmetra,
            torbjorn, tracer, widowmaker, winston, wreckingBall, zarya, zenyatta)
        dbRepo.insertHeroList(heroList)
    }
}