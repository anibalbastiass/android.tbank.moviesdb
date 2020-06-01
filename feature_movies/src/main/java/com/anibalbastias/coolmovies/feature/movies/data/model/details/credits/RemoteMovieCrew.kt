package com.anibalbastias.coolmovies.feature.movies.data.model.details.credits

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.CREDIT_ID
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.DEPARTMENT
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.GENDER
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ID
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.JOB
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.NAME
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.PROFILE_PATH
import com.squareup.moshi.Json

data class RemoteMovieCrew(
    @field:Json(name = GENDER) val gender: Int? = null,
    @field:Json(name = CREDIT_ID) val creditId: String? = null,
    @field:Json(name = NAME) val name: String? = null,
    @field:Json(name = PROFILE_PATH) val profilePath: String? = null,
    @field:Json(name = ID) val id: Int? = null,
    @field:Json(name = DEPARTMENT) val department: String? = null,
    @field:Json(name = JOB) val job: String? = null
)