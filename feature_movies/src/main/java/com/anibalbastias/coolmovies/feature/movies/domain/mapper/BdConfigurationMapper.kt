package com.anibalbastias.coolmovies.feature.movies.domain.mapper

import com.anibalbastias.coolmovies.feature.movies.data.room.Constants.TABLE_CONFIGURATION
import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfigurationImages
import com.anibalbastias.coolmovies.feature.movies.domain.model.database.EntityConfiguration

class BdConfigurationMapper {

    companion object {
        const val COMMA = ","
    }

    fun EntityConfiguration.fromDatabaseToDomain() =
        DomainConfiguration(
            images = makeDomainConfigurationImages(this),
            changeKeys = arrayListOf() //changeKeys
        )

    private fun makeDomainConfigurationImages(entity: EntityConfiguration) = entity.run {
        DomainConfigurationImages(
            baseUrl = entity.baseUrl,
            secureBaseUrl = entity.secureBaseUrl,
            backDropSizes = entity.backDropSizes.joinToList(),
            logoSizes = entity.logoSizes.joinToList(),
            posterSizes = entity.posterSizes.joinToList(),
            profileSizes = entity.profileSizes.joinToList(),
            stillSizes = entity.stillSizes.joinToList()
        )
    }

    fun DomainConfiguration.fromDomainToDatabase() = EntityConfiguration(
        id = TABLE_CONFIGURATION,
        baseUrl = images.baseUrl,
        secureBaseUrl = images.secureBaseUrl,
        backDropSizes = images.backDropSizes.joinToString(),
        logoSizes = images.logoSizes.joinToString(),
        posterSizes = images.posterSizes.joinToString(),
        profileSizes = images.profileSizes.joinToString(),
        stillSizes = images.stillSizes.joinToString(),
        changeKeys = changeKeys.joinToString()
    )

    private fun String.joinToList(): ArrayList<String> {
        val split = split(COMMA)
        val list = arrayListOf<String>()
        split.map {
            list.add(it)
        }
        return list
    }

}