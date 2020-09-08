package com.example.callofdutymw_stats.viewmodel

import androidx.lifecycle.liveData
import com.example.callofdutymw_stats.domain.RepositoryImpl
import com.example.callofdutymw_stats.util.Resource
import kotlinx.coroutines.Dispatchers

class UserInformationViewModel {

    private val repository = RepositoryImpl()

    fun getWarzoneUser(
        gamertag: String,
        platform: String
    ) = liveData(Dispatchers.IO) {

        emit(Resource.loading(null))
        try {
            emit(Resource.success(repository.getWarzoneUser(gamertag, platform)))
        } catch (e: Exception) {
            emit(Resource.error(null, e.toString()))
        }
    }
    companion object {
        fun responseKDRatioIsValid(response: String): Boolean {
            return response.toDouble() != 0.0
        }
        fun responseAccuracyIsValid(accuracy: String): Boolean {
            return accuracy.toInt() != 0
        }
    }
}