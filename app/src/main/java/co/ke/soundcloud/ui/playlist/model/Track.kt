package co.ke.soundcloud.ui.playlist.model

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
    val user: User

) {
    override fun equals(other: Any?): Boolean {
        if (javaClass != other?.javaClass) {
            return false
        }

        other as Track

        return when {
            id == other.id -> true
            title == other.title -> true
            uri == other.uri -> true
            duration == other.duration -> true
            user == other.user -> true
            else -> false
        }
    }
}