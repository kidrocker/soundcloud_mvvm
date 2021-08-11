package co.ke.soundcloud.ui.playlist.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Long,

    @SerializedName("full_name")
    val fullName: String,

    @SerializedName("username")
    val userName: String,
)
