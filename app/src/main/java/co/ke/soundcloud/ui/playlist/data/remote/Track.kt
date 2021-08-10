package co.ke.soundcloud.ui.playlist.data.remote

import com.google.gson.annotations.SerializedName
import java.util.*

data class Track(
    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String,

    @SerializedName("uri")
    val uri: String,

    @SerializedName("artwork_url")
    val artwork: String,

    @SerializedName("duration")
    val duration: Date,

    @SerializedName("user")
    val artist: Artist

)