package com.nalka.overwatchnews.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nalka.overwatchnews.model.db.dao.HeroAbilityDao
import com.nalka.overwatchnews.model.db.dao.HeroDao
import com.nalka.overwatchnews.model.model.Hero
import com.nalka.overwatchnews.model.model.HeroAbility

@Database(
    entities = [
        Hero::class,
        HeroAbility::class
    ],
    version = 1
)
abstract class Db : RoomDatabase() {

    companion object {
        private const val DB_NAME = "overwatch.db"

        @Volatile
        private var instance: Db? = null

        fun getInstance(context: Context): Db {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(context, Db::class.java, DB_NAME).build()
                    }
                }
            }
            return instance!!
        }
    }

    abstract fun heroDao(): HeroDao
    abstract fun heroAbilityDao(): HeroAbilityDao
}