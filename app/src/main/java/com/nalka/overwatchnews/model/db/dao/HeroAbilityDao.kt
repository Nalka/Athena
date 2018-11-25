package com.nalka.overwatchnews.model.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import com.nalka.overwatchnews.model.model.HeroAbility

@Dao
interface HeroAbilityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    fun insertHeroAbilities(heroAbilityList: List<HeroAbility>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHeroAbility(heroAbility: HeroAbility)
}