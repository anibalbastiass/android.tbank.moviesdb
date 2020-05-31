package com.anibalbastias.coolmovies.feature.movies.domain.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.anibalbastias.coolmovies.feature.movies.data.room.Constants.TABLE_CONFIGURATION

@Entity(tableName = TABLE_CONFIGURATION)
data class EntityConfiguration(
    @PrimaryKey
    val id: String,
    val baseUrl: String,
    val secureBaseUrl: String,
    val backDropSizes: String,
    val logoSizes: String,
    val posterSizes: String,
    val profileSizes: String,
    val stillSizes: String,
    val changeKeys: String
)