package co.ke.soundcloud.data.remote

import com.google.gson.annotations.SerializedName

data class RemoteTrack(
    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String,

    @SerializedName("uri")
    val uri: String,

    @SerializedName("artwork_url")
    val artwork: String,

    @SerializedName("duration")
    val duration: Long,

    @SerializedName("user")
    val artist: RemoteArtist

)