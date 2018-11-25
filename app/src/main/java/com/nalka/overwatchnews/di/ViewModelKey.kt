package com.nalka.overwatchnews.di

import androidx.lifecycle.ViewModel
import com.nalka.overwatchnews.di.scope.AppScope
import dagger.MapKey
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)