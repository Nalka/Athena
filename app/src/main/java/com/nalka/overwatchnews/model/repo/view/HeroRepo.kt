package com.nalka.overwatchnews.model.repo.view

import androidx.lifecycle.LiveData
import com.nalka.overwatchnews.R
import com.nalka.overwatchnews.model.model.Hero
import com.nalka.overwatchnews.model.repo.DBRepo
import javax.inject.Inject

class HeroRepo
    @Inject
    constructor(
        private val dbRepo: DBRepo
    ) {

    init { // NOTE!!
        // this is temporary; this data will eventually be requested from API; just needed some data to display
        // and to setup database calls
        val heroList = mutableListOf<Hero>()
        val names = listOf("Ana", "Ashe", "Bastion", "Brigite", "D.Va",
            "Doomfist", "Genji", "Hanzo", "Junkrat", "Lúcio", "McCree", "Mei",
            "Mercy", "Moira", "Orisa", "Phara", "Reaper", "Reinhardt", "Roadhog",
            "Soldier 76", "Sombra", "Symmetra", "Torbjörn", "Tracer", "Widowmaker",
            "Winston", "Wrecking Ball", "Zarya", "Zenyatta")
        val iconIds = listOf(R.drawable.icon_ana, R.drawable.icon_ashe,
            R.drawable.icon_bastion, R.drawable.icon_brigitte, R.drawable.icon_dva,
            R.drawable.icon_doomfist, R.drawable.icon_genji, R.drawable.icon_hanzo,
            R.drawable.icon_junkrat, R.drawable.icon_lucio, R.drawable.icon_mccree,
            R.drawable.icon_mei, R.drawable.icon_mercy, R.drawable.icon_moira,
            R.drawable.icon_orisa, R.drawable.icon_pharah, R.drawable.icon_reaper,
            R.drawable.icon_reinhardt, R.drawable.icon_roadhog, R.drawable.icon_soldier_76,
            R.drawable.icon_sombra, R.drawable.icon_symmetra, R.drawable.icon_torbjorn,
            R.drawable.icon_tracer, R.drawable.icon_widowmaker, R.drawable.icon_winston,
            R.drawable.icon_wrecking_ball, R.drawable.icon_zarya, R.drawable.icon_zenyatta)
        for(i in 0 until names.size) {
            val hero = Hero()
            hero.id = i.toLong()+1
            hero.name = names[i]
            hero.iconId = iconIds[i]
            heroList.add(hero)
        }
        dbRepo.insertHeroList(heroList)
    }

    fun getHeroList() : LiveData<List<Hero>> {
        return dbRepo.getHeroListLight()
    }

    fun getHeroDetails(id: Long): LiveData<Hero> {
        return dbRepo.getHeroById(id)
    }
}