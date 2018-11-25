package com.nalka.overwatchnews.screens.heroes.detail

import androidx.lifecycle.ViewModel
import com.nalka.overwatchnews.model.repo.view.HeroRepo
import javax.inject.Inject

class HeroDetailsFragmentVM
    @Inject
    constructor(
        private val heroRepo: HeroRepo
    ) : ViewModel() {

    fun getHeroById(id: Long) = heroRepo.getHeroDetails(id)

}