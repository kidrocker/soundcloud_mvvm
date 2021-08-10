package co.ke.soundcloud.data.remote

import co.ke.soundcloud.data.model.Track
import com.google.gson.annotations.SerializedName


// use gson serialization to serialize data to objects
data class RemotePlaylist(
    @SerializedName("title")
    val title: String,

    @SerializedName("duration")
    val duration: Long,

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
    val tracks:List<RemoteTrack>
)
