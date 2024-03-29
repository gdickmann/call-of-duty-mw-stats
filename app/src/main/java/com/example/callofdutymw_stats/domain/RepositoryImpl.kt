package com.example.callofdutymw_stats.domain

import com.example.callofdutymw_stats.data.repository.Repository
import com.example.callofdutymw_stats.rest.endpoint.EndPoint
import com.example.callofdutymw_stats.rest.retrofit.RetrofitConfiguration

class RepositoryImpl : Repository {

    private val endPoint = RetrofitConfiguration.getClient().create(EndPoint::class.java)

    override suspend fun getMultiplayerUser(
        gamertag: String,
        platform: String
    ) = endPoint.getMultiplayerUser(gamertag, platform)

    override suspend fun getWarzoneUser(
        gamertag: String,
        platform: String
    ) = endPoint.getWarzoneUser(gamertag, platform)
}