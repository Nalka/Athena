package com.nalka.overwatchnews.screens.heroes.list

import androidx.lifecycle.ViewModel
import com.nalka.overwatchnews.model.repo.view.HeroRepo
import javax.inject.Inject

class HeroListFragmentVM
    @Inject
    constructor(
        private val heroRepo: HeroRepo
    ) : ViewModel() {

    fun getHeroList() = heroRepo.getHeroList()

}