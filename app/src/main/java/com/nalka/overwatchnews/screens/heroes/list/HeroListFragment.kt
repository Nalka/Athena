package com.nalka.overwatchnews.screens.heroes.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.nalka.overwatchnews.R
import com.nalka.overwatchnews.model.model.Hero
import com.nalka.overwatchnews.screens.heroes.list.utils.HeroListAdapter
import com.nalka.overwatchnews.screens.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_hero_list.*

class HeroListFragment : BaseFragment() {
    private lateinit var viewModel: HeroListFragmentVM

    private var adapter: HeroListAdapter? = null
    private val heroListObserver: Observer<List<Hero>> = Observer {
        heroList ->
        displayHeroes(heroList)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hero_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(HeroListFragmentVM::class.java)

        initViews()

        val heroListToObserve = viewModel.getHeroList()
        if(!heroListToObserve.hasObservers()) {
            heroListToObserve.observe(this, heroListObserver)
        }
    }

    private fun initViews() {
        rv_hero_list.layoutManager = GridLayoutManager(context, 4)
        adapter = HeroListAdapter(listOf()) {
                hero ->
            val directions =
                HeroListFragmentDirections
                    .actionHeroesListFragmentToHeroesDetailsFragment()
                    .setHeroId(hero.id.toString())
            findNavController().navigate(directions)
        }
        rv_hero_list.adapter = adapter
    }

    private fun displayHeroes(heroList: List<Hero>) {
        adapter?.heroList = heroList
        adapter?.notifyDataSetChanged()
    }
}