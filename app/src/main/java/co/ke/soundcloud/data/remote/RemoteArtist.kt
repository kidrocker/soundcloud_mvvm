package co.ke.soundcloud.data.remote

import com.google.gson.annotations.SerializedName

data class RemoteArtist(
    @SerializedName("id")
    val id: Long,

    @SerializedName("full_name")
    val name: String,
)
