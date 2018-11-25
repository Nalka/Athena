package com.nalka.overwatchnews.screens.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nalka.overwatchnews.App
import com.nalka.overwatchnews.di.ViewModelFactory
import javax.inject.Inject

open class BaseFragment: Fragment() {
    companion object {
        val TAG = this::class.java.simpleName
    }
    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (activity?.applicationContext as App).mAppComponent.inject(this)
    }

}