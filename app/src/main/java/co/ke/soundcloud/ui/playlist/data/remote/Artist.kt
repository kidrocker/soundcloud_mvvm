package co.ke.soundcloud.ui.playlist.data.remote

import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("id")
    val id: Long,

    @SerializedName("full_name")
    val name: String,
)
