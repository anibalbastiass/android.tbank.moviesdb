package com.anibalbastias.coolmovies.feature.movies.domain.database.dao

import androidx.room.*
import com.anibalbastias.coolmovies.feature.movies.domain.model.database.EntityConfiguration

@Dao
interface ConfigurationDao {

    @Query("SELECT * FROM configuration")
    suspend fun getConfiguration(): EntityConfiguration?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveConfiguration(vararg user: EntityConfiguration)

}