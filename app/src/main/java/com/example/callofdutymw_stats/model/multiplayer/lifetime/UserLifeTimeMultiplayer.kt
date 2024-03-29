package com.example.callofdutymw_stats.model.multiplayer.lifetime

import com.example.callofdutymw_stats.model.multiplayer.lifetime.all.UserAllMultiplayer
import com.google.gson.annotations.SerializedName

class UserLifeTimeMultiplayer(
    @SerializedName("lifetime")
    val userAllMultiplayer: UserAllMultiplayer,
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("level")
    val level: Int,
    @SerializedName("username")
    val nickName: String,
    @SerializedName("platform")
    val platform: String
) {
}