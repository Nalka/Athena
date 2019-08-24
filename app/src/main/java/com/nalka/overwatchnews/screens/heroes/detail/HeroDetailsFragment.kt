package com.nalka.overwatchnews.screens.heroes.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nalka.overwatchnews.R
import com.nalka.overwatchnews.model.model.Hero
import com.nalka.overwatchnews.model.utils.loadDrawable
import com.nalka.overwatchnews.screens.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_hero_details.*

class HeroDetailsFragment : BaseFragment() {

    private lateinit var viewModel: HeroDetailsFragmentVM

    private val heroObserver: Observer<Hero> = Observer {
        hero ->
        initViews(hero)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(HeroDetailsFragmentVM::class.java)

        val heroToObserve = viewModel.getHeroById(getHeroId())
        if(!heroToObserve.hasObservers()) {
            heroToObserve.observe(this, heroObserver)
        }
    }

    private fun getHeroId(): Long {
        return HeroDetailsFragmentArgs.fromBundle(arguments!!).heroId.toLong()
    }

    private fun initViews(hero: Hero) {
        tv_hero_name.text = hero.name
        iv_hero_icon.loadDrawable(hero.iconId)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_hero_details
    }
}