package com.nalka.overwatchnews.model.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nalka.overwatchnews.model.model.Hero

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    fun insertHeroes(list: List<Hero>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(hero: Hero)

    @Query("SELECT id, name, iconId FROM hero")
    fun getHeroListLight(): LiveData<List<Hero>>

    @Query("SELECT * FROM hero")
    fun getHeroList(): LiveData<List<Hero>>

    @Query("SELECT * FROM hero")
    fun getHeroListSync(): List<Hero>

    @Query("SELECT * FROM hero WHERE id = :id")
    fun getHeroById(id: Long): LiveData<Hero>
}