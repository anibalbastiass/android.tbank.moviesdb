package com.anibalbastias.coolmovies.feature.movies.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anibalbastias.coolmovies.feature.movies.data.room.Constants.DATABASE_VERSION
import com.anibalbastias.coolmovies.feature.movies.domain.database.dao.ConfigurationDao
import com.anibalbastias.coolmovies.feature.movies.domain.model.database.EntityConfiguration

@Database(
    entities = [
        EntityConfiguration::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract val configuration: ConfigurationDao
}