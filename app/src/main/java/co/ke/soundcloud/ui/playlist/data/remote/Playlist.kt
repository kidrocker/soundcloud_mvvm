package co.ke.soundcloud.ui.playlist.data.remote

import com.google.gson.annotations.SerializedName
import java.util.*

// use gson serialization to serialize data to objects
data class Playlist(
    @SerializedName("title")
    val title: String,

    @SerializedName("duration")
    val duration: Date,

    @SerializedName("description")
    val description: String?,

    @SerializedName("uri")
    val uri: String,

    @SerializedName("artwork_url")
    val artwork: String,

    @SerializedName("track_count")
    val trackCount: Int,

    @SerializedName("id")
    val playlistID: Int,

    @SerializedName("tracks")
    val tracks:List<Track>
)
